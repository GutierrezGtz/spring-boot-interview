package com.compasso.springbootinterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.springbootinterview.model.City;
import com.compasso.springbootinterview.model.Estate;
import com.compasso.springbootinterview.repository.CityRepository;
import com.compasso.springbootinterview.repository.EstateRepository;

@RestController
@RequestMapping({ "/address" })
public class AddressController {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private EstateRepository estateRepository;
	
	@PostMapping(value = "/estate")
	public Estate createEstate(@RequestBody Estate estate) {
		return estateRepository.save(estate);

	}
	
	@PostMapping(value = "/city/{estateCode}")
	public ResponseEntity<City> createCity(@PathVariable(value = "estateCode") Long estateCode, @RequestBody City city) {
		return estateRepository.findById(estateCode).map(record -> {
			city.setEstateCode(record);
			City created = cityRepository.save(city);
			return ResponseEntity.ok().body(created);
		}).orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping(path = { "/city/{cityName}" })
	public ResponseEntity<?> findByCityName(@PathVariable String cityName) {
		return cityRepository.findByCityName(cityName).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "/estate/{estateName}" })
	public ResponseEntity<?> findByEstateName(@PathVariable String estateName) {
		return estateRepository.findByEstateName(estateName).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
