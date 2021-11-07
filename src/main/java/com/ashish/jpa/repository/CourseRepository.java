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
	// demo method 
	// flush : Synchronize the persistence context to the underlying database
	// detach : Remove the given entity from the persistence context
	// clear :  Clear the persistence context, causing all managed entities to become detached
	// refresh : Refresh the state of the instance from the database, overwriting changes made to the entity, if any.
	public void demoEntitymanager() {
		Course objCourse = new Course("WebService in 100 steps.");
		em.persist(objCourse);
		em.flush();
		//em.detach(objCourse);
		//em.clear();
		
		Course objCourse1 = new Course("Angular+2 in 100 steps.");
		em.persist(objCourse1);
		em.flush();
		//em.detach(objCourse1);
		//em.clear();
		
		//em.clear();
		objCourse.setName("WebService in 100 steps - Updated");
		//em.flush();
		
		objCourse1.setName("Angular+2 in 100 steps - Updated");
		
		em.refresh(objCourse);
		em.flush();
	}
}
