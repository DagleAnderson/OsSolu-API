package com.solutech.soluos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solutech.soluos.domain.DTO.NewOrdemServicoDTO;
import com.solutech.soluos.domain.DTO.OrdemServicoDTO;
import com.solutech.soluos.domain.model.OrdemServico;
import com.solutech.soluos.domain.repository.OrdemServicoRepository;
import com.solutech.soluos.domain.services.OrdemServicoServices;

@RestController
@RequestMapping("/ordemservico")
public class OrderServicoController {

	@Autowired
	private OrdemServicoServices service;
	
	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired // ModelMapper é  uma dependência do Maven usada para  evitar codigo Boilerplate de DTO
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoDTO create(@Valid @RequestBody NewOrdemServicoDTO  NewobjDTO) {
		OrdemServico ordem = toEntity(NewobjDTO);
		
		return  toModel(service.save(ordem));
	}

	@GetMapping
	public List<OrdemServicoDTO> findAll(){
		return toCollectionModel(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> findById(@PathVariable Long id) {
		Optional<OrdemServico> ordemOp =  repository.findById(id);
		
		if(ordemOp.isPresent()) {
			OrdemServicoDTO objDTO = toModel(ordemOp.get());
			return  ResponseEntity.ok(objDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{ordemServicoId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemServicoId) {
		 service.finallyOrder(ordemServicoId);
	}
	
	private List<OrdemServicoDTO> toCollectionModel(List<OrdemServico> ordens){
		return ordens.stream()
				.map(ordemServico -> toModel(ordemServico))
				.collect(Collectors.toList());
		
	}
	
	private OrdemServicoDTO toModel(OrdemServico obj) {
		// TODO Auto-generated method stub
		return modelMapper.map(obj,OrdemServicoDTO.class);
	}

	private OrdemServico toEntity(NewOrdemServicoDTO newobjDTO) {
		OrdemServico newOrdem = modelMapper.map(newobjDTO, OrdemServico.class);
		return newOrdem;
	}
}
