package com.solutech.soluos.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutech.soluos.domain.model.Cliente;
import com.solutech.soluos.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente save(Cliente obj) {
		return repository.save(obj);
	}

	public void delete(Long objId) {
		repository.deleteById(objId);
		;
	}
}
