package com.solutech.soluos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solutech.soluos.domain.DTO.ComentarioDTO;
import com.solutech.soluos.domain.exception.NotFoundException;
import com.solutech.soluos.domain.model.Comentario;
import com.solutech.soluos.domain.model.OrdemServico;
import com.solutech.soluos.domain.repository.OrdemServicoRepository;
import com.solutech.soluos.domain.services.OrdemServicoServices;

@RestController
@RequestMapping("/ordemservico/{ordemServicoId}/comentarios")
public class ComentarioController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrdemServicoRepository ordemRepository;
	
	@Autowired
	private  OrdemServicoServices ordemServices;
	
	@GetMapping
	public List<ComentarioDTO> findAll(@PathVariable Long ordemServicoId){
		OrdemServico ordem = ordemRepository.findById(ordemServicoId)
				.orElseThrow(()-> new NotFoundException("Ordem de serviço não encontrada!"));
		
		return toColletionModel(ordem.getComentarios());
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioDTO create(@PathVariable Long ordemServicoId,@RequestBody ComentarioDTO objDTO) {
		Comentario comentario = ordemServices.AddComentario(ordemServicoId, objDTO.getDescricao());
		
		return toModel(comentario);
	}
	
	
	private List<ComentarioDTO> toColletionModel(List<Comentario> comentarios) {
		
		return comentarios.stream()
				.map(comentario -> toModel(comentario))
				.collect(Collectors.toList());
	}

	private ComentarioDTO toModel(Comentario comentario) {
		ComentarioDTO objDTO =  modelMapper.map(comentario, ComentarioDTO.class);
		return objDTO;
	}
	
	
	
}
