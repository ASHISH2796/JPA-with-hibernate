package com.ashish.jpa.repository;
/**
 * @author Ashish Gupta
 *
 */

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course objCourse) {
		if(objCourse.getId() == null) {
			em.persist(objCourse);
		} else { 
			em.merge(objCourse);	
		} 
		
		return objCourse;
	}
	
	public void deleteById(Long id) {
		Course objCourse = findById(id);
		em.remove(objCourse);
	}
}
