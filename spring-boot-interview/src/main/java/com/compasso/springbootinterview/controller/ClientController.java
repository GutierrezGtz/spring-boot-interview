package com.compasso.springbootinterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.springbootinterview.model.Client;
import com.compasso.springbootinterview.repository.CityRepository;
import com.compasso.springbootinterview.repository.ClientRepository;

@RestController
@RequestMapping({ "/clients" })
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CityRepository cityRepository;

	@GetMapping
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@PostMapping(value = "/{cityCode}")
	public ResponseEntity<Client> create(@PathVariable(value = "cityCode") Long cityCode, @RequestBody Client client) {
		return cityRepository.findById(cityCode).map(record -> {
			client.setCityCode(record);
			Client created = clientRepository.save(client);
			return ResponseEntity.ok().body(created);
		}).orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/name/{id}")
	public ResponseEntity<Client> updateName(@PathVariable("id") Long id, @RequestBody String clientName) {
		return clientRepository.findById(id).map(record -> {
			record.setClientName(clientName);
			Client updated = clientRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return clientRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(path = { "/name/{clientName}" })
	public ResponseEntity<?> findByClientName(@PathVariable String clientName) {
		return clientRepository.findByClientName(clientName).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return clientRepository.findById(id).map(record -> {
			clientRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/name/{clientName}" })
	public ResponseEntity<?> deleteByClientName(@PathVariable String clientName) {
		return clientRepository.findByClientName(clientName).map(record -> {
			clientRepository.deleteByClientName(clientName);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
