
package com.ashish.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.jpa.entity.Course;

/**
 * @author Ashish Gupta
 *
 */
@Repository
@Transactional
public class JPQLCourseRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	public void findByid() {
		Query query = em.createQuery("SELECT c FROM Course c");
		List data = query.getResultList();
		log.info("SELECT c FROM course c -> {} ", data);
	}
	
	public void findById_type() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c",Course.class);
		List<Course> data = query.getResultList();
		log.info("SELECT c FROM course c -> {} ", data);
	}
	
	public void findById_where() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.name like '%100'",Course.class);
		List<Course> data = query.getResultList();
		log.info("SELECT c FROM Course c WHERE c.name like '%100' -> {} ", data);
	}
}
