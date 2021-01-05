package com.compasso.springbootinterview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compasso.springbootinterview.model.City;

@Transactional
@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	Optional<City> findByCityName(String cityName);

}
