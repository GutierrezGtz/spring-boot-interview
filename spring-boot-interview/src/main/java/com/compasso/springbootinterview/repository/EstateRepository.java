package com.compasso.springbootinterview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compasso.springbootinterview.model.Estate;

@Transactional
@Repository
public interface EstateRepository extends JpaRepository<Estate, Long>{

	Optional<Estate> findByEstateName(String estateName);

}
