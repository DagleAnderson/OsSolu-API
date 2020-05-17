package com.solutech.soluos.domain.services;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.solutech.soluos.domain.Enum.StatusOrderService;
import com.solutech.soluos.domain.exception.DBException;
import com.solutech.soluos.domain.exception.NotFoundException;
import com.solutech.soluos.domain.model.Cliente;
import com.solutech.soluos.domain.model.Comentario;
import com.solutech.soluos.domain.model.OrdemServico;
import com.solutech.soluos.domain.repository.ClienteRepository;
import com.solutech.soluos.domain.repository.ComentarioRepository;
import com.solutech.soluos.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoServices {

	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico save(OrdemServico obj) {
		Cliente cliente = clienteRepository.findById(obj.getCliente().getId())
				.orElseThrow(()->new DBException("cliente não encontrado"));
		
		obj.setCliente(cliente);
		obj.setStatus(StatusOrderService.ABERTA);
		obj.setDataAbertura(OffsetDateTime.now());

		return repository.save(obj);
	}
	
	@PutMapping
	public void finallyOrder(Long ordemServicoId) {
		OrdemServico ordemServico =buscaOrdem(ordemServicoId);
		
		
		ordemServico.finalizar();
		
		repository.save(ordemServico);
	}

	public void delete(Long ordemServicoId) {

	}

	
	public Comentario AddComentario(Long ordemServicoId, String descricao){
		OrdemServico ordemServico =buscaOrdem(ordemServicoId);
		
		Comentario comentario  = new Comentario();
		comentario.setDataEnv(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		
		return comentarioRepository.save(comentario);
	}
	
	private OrdemServico buscaOrdem(Long ordemServicoId) {
		return repository.findById(ordemServicoId)
				.orElseThrow(()->new  NotFoundException("Ordem de serviço não encontrada"));
	}

}
