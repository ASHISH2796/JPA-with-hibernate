package com.ashish.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
@Entity
public class PartTimeEmployee extends Employee{
	
	private BigDecimal hourlyWage;
	
	
	/**
	 * default constructor 
	 */
	public PartTimeEmployee() {
	}

	/**
	 * @param hourlyWage
	 */
	public PartTimeEmployee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

}
