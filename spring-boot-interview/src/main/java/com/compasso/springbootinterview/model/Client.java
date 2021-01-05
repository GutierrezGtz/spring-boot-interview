package com.compasso.springbootinterview.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.compasso.springbootinterview.protocol.Gender;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientcode", nullable = false)
	private Long id;
	
	@Column(name = "clientname")
	private String clientName;
	@Column(name = "dateofbirth")
	private Date dateOfBirth;
	@Column
	private Integer age;
	
	@Column(name = "gendercode")
	@Enumerated(EnumType.STRING)
	private Gender genderCode;
	
	@OneToOne
	@JoinColumn(name = "citycode")
	private City cityCode;

	
	public City getCityCode() {
		return cityCode;
	}
	public void setCityCode(City cityCode) {
		this.cityCode = cityCode;
	}
	public Gender getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(Gender genderCode) {
		this.genderCode = genderCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
