package com.ashish.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
@Entity
public class FullTimeEmployee extends Employee{
	
	private BigDecimal salary;
	
	
	/**
	 * default constructor 
	 */
	public FullTimeEmployee() {
	}

	/**
	 * @param salary
	 */
	public FullTimeEmployee(String name,BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

}
