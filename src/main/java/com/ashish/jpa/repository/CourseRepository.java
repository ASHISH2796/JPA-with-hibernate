package com.ashish.jpa.repository;
/**
 * @author Ashish Gupta
 *
 */

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashish.jpa.entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void save(Course obj) {
		 em.persist(obj);
	}
}
