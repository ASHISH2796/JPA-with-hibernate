package com.ashish.jpa.repository;
/**
 * @author Ashish Gupta
 *
 */

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.jpa.entity.Course;
import com.ashish.jpa.entity.Employee;
import com.ashish.jpa.entity.Review;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger log =LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;
	
	public void insert(Employee emp) {
		 em.persist(emp);
	}
	
	/*public List<Employee> retriveAllEmployee(){
		return em.createQuery("from Employee").getResultList();
	}
	*/
	public List<Employee> retriveFullTimeEmployee(){
		return em.createQuery("from FullTimeEmployee").getResultList();
	}
	
	public List<Employee> retrivePartTimeEmployee(){
		return em.createQuery("from PartTimeEmployee").getResultList();
	}
}
