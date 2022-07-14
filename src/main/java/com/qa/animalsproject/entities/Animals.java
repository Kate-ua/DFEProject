package com.qa.animalsproject.entities;

import java.util.Objects;

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
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable = false, unique=true)
	private Integer age;
	
	@Column(nullable = false)
	private String habitat;
	
	@Column(nullable = false)
	private Integer numOfLegs;
	
	public Animals() {}

	public Animals(long id, String type, int age, String habitat, int numOfLegs) {
		super();
		this.id=id;
		this.type=type;
		this.age=age;
		this.habitat=habitat;
		this.numOfLegs=numOfLegs;
		
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public Integer getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(Integer numOfLegs) {
		this.numOfLegs = numOfLegs;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(age, type, habitat, id, numOfLegs);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animals other = (Animals) obj;
		return Objects.equals(age, other.age) && Objects.equals(type, other.type) && Objects.equals(habitat, other.habitat) 
				&& id == other.id && Objects.equals(numOfLegs, other.numOfLegs);
		
		
	}

	

}
