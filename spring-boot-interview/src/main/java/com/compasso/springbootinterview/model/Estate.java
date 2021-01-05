package com.compasso.springbootinterview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTATE")
public class Estate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estatecode", nullable = false)
	private Long id;
	
	@Column(name = "estatename")
	private String estateName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
}
