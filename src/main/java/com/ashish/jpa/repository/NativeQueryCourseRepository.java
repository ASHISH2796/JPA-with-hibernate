
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
public class NativeQueryCourseRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	public void findByid() {
		Query query = em.createNativeQuery("SELECT * FROM Course",Course.class);
		List data = query.getResultList();
		log.info("SELECT * FROM Course -> {} ", data);
	}
	
	public void findById_positional_param(Long id) {
		Query query = em.createNativeQuery("SELECT * FROM Course where id =?",Course.class);
		query.setParameter(1, id);
		List data = query.getResultList();
		log.info("SELECT * FROM Course where id = ? -> {} ", data);
	}
	
	public void findById_named_param(Long id) {
		Query query = em.createNativeQuery("SELECT * FROM Course where id =:id ",Course.class);
		query.setParameter("id", id);
		List data = query.getResultList();
		log.info("SELECT * FROM Course where id = ? -> {} ", data);
	}
	
	public void updateCourseById() {
		Query query = em.createNativeQuery("UPDATE course SET last_updated_date=sysdate()");
		int noOfUpdatedRows = query.executeUpdate();
		log.info("UPDATE course SET last_updated_date=sysdate() -> {} ", noOfUpdatedRows);
	}
}
