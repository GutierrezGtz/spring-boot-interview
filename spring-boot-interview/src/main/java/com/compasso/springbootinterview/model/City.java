package com.compasso.springbootinterview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citycode", nullable = false)
	private Long id;
	
	@Column(name = "cityname")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "estatecode")
	private Estate estateCode;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public Estate getEstateCode() {
		return estateCode;
	}
	
	public void setEstateCode(Estate estateCode) {
		this.estateCode = estateCode;
	}
}
