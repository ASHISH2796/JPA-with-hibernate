
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
import com.ashish.jpa.entity.Student;

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
	
	public void findById_without_student() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.students is empty",Course.class);
		List<Course> data = query.getResultList();
		log.info("Result list' -> {} ", data);
	}
	
	public void findById_atleast2_student() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE size(c.students) >= 2 ",Course.class);
		List<Course> data = query.getResultList();
		log.info("Result list' -> {} ", data);
	}

	public void findByIdOrderbyStudent() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c order by  size(c.students) desc ",Course.class);
		List<Course> data = query.getResultList();
		log.info("Result list' -> {} ", data);
	}
	
	public void findStudentBycertainpattern() {
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s where s.passport.number like '%MH1%'  ",Student.class);
		List<Student> data = query.getResultList();
		log.info("Result list' -> {} ", data);
	}
	
	public void join() {
		Query query = em.createQuery("SELECT c,s FROM Course c JOIN c.students s");
		List<Object[]> data = query.getResultList();
		for(Object[] result : data ) {
			log.info("Course => {} and Student => {} ", result[0],result[1]);
		}
	}
	
	public void leftJoin() {
		Query query = em.createQuery("SELECT c,s FROM Course c LEFT JOIN c.students s");
		List<Object[]> data = query.getResultList();
		for(Object[] result : data ) {
			log.info("Course => {} and Student => {} ", result[0],result[1]);
		}
	}
	
	public void crossJoin() {
		Query query = em.createQuery("SELECT c,s FROM Course c ,Student s");
		List<Object[]> data = query.getResultList();
		for(Object[] result : data ) {
			log.info("Course => {} and Student => {} ", result[0],result[1]);
		}
	}
}
