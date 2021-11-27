package com.ashish.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="find_course_by_id",query="SELECT c FROM Course c"),
			@NamedQuery(name="find_course_by_id_where",query="SELECT c FROM Course c WHERE name like '%100'")
		}
	)
@Cacheable
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="course")
	private List<Review> listOfReviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students =new ArrayList<>();
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	

	/**
	 * default constructor 
	 */
	public Course() {
	}

	/**
	 * @param name
	 */
	public Course(String name) {
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

	/**
	 * @return the listOfReviews
	 */
	public List<Review> getListOfReviews() {
		return listOfReviews;
	}

	/**
	 * @param listOfReviews the listOfReviews to set
	 */
	public void setListOfReviews(List<Review> listOfReviews) {
		this.listOfReviews = listOfReviews;
	}
	
	public void addReview(Review review) {
		this.listOfReviews.add(review);
	}

	public void removeReview(Review review) {
		this.listOfReviews.remove(review);
	}
	
	
	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	

}
