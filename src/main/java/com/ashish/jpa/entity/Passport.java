package com.ashish.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String number;
	
	
	/**
	 * Bi-directional relationship with Student(owner) entity 
	 */
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
	private Student student;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	

	/**
	 * default constructor 
	 */
	public Passport() {
	}

	/**
	 * @param number
	 */
	public Passport(String number) {
		this.number = number;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student=" + student + "]";
	}
	
}
