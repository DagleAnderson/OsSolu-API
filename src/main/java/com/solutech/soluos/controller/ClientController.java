package com.solutech.soluos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solutech.soluos.domain.model.Cliente;
import com.solutech.soluos.domain.repository.ClienteRepository;
import com.solutech.soluos.domain.services.ClienteService;
import com.solutech.soluos.domain.exception.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private ClienteService service;

	@Autowired
	private ClienteRepository repository;

	// @RequestMapping( method = RequestMethod.GET)
	@GetMapping("")
	public List<Cliente> findAll() {

		return repository.findAll();
	}

	// @RequestMapping(value="/{id}", method = RequestMethod.GET)
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = repository.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insert(@Valid @RequestBody Cliente obj) {
		Cliente cliExists = repository.findByEmail(obj.getEmail());

		if (cliExists != null && !cliExists.equals(obj)) {
			throw new DBException("Email ou usuário ja existente!");
		}
		return service.save(obj);
	}

	// @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		obj.setId(id);
		obj = service.save(obj);

		return ResponseEntity.ok(obj);
	}

	@DeleteMapping("/{id}") // Deletando dados por Id
	public ResponseEntity<Void> remove(@PathVariable Long id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
