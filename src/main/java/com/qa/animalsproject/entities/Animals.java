package com.qa.animalsproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Animals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "type", nullable=false)
	private String type;
	
	@Column(nullable = false)
	private Integer age;
	
	@Column(nullable = false)
	private String habitat;
	
	@Column(nullable = false)
	private Integer numOfLegs;
	
	public Animals() {}

	public Animals(long id, String type, Integer age, String habitat, Integer numOfLegs) {
		super();
		this.id=id;
		this.type=type;
		this.age=age;
		this.habitat=habitat;
		this.numOfLegs=numOfLegs;
		
	}

	


}
