package com.compasso.springbootinterview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compasso.springbootinterview.model.Client;

@Transactional
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{

	Optional<Client> findByClientName(String clientName);

	void deleteByClientName(String clientName);

}
