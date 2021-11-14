package com.ashish.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import com.ashish.jpa.JpaWithHibernateApplication;
import com.ashish.jpa.entity.Course;

@SpringBootTest(classes=JpaWithHibernateApplication.class)

/**
 * @author Ashish Gupta
 *
 */
class CourseSpringDataRepoTest {

	private Logger log =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepo repo;
	
	@Test
	@DisplayName("To find by id to check if course present.")
	void findById_CoursePresent() {
	  Optional<Course> findById = repo.findById(1001l);
	  assertTrue(findById.isPresent());
	}
	
	@Test
	@DisplayName("To find by id to check if course not present.")
	void findById_CourseNotPresent() {
	  Optional<Course> findById = repo.findById(10001l);
	  assertFalse(findById.isPresent());
	}
	
	@Test
	@DisplayName("To test all CURD operation")
	void CRUDOperation() {
		Course course =new Course("Micorservice in 100 steps");
		repo.save(course);
		
		course.setName("Micorservice in 100 steps - Updated");
		
		repo.save(course);
		
		Sort sort = Sort.by(Sort.Direction.DESC,"name");
		log.info("course -> {} ", repo.findAll(sort));
		log.info("course -> {} ", repo.count());
		repo.delete(course);
	}
	
	@Test
	@DisplayName("Pagination implementation")
	void pagination () {
		PageRequest pageRequest =PageRequest.of(0,1);
		Page<Course> firstPage = repo.findAll(pageRequest);
		log.info("first page :=>{}",firstPage.getContent());
		
		Pageable secondPageable =firstPage.nextPageable();
		Page<Course> secondPage = repo.findAll(secondPageable);
		log.info("second page :=>{}",secondPage.getContent());
		  
	}
	
	@Test
	@DirtiesContext
	@DisplayName("Custom query implementation")
	void testCustomeQueryImpl() {
		log.info(" findByName :=>{}",repo.findByName("Hibernate -in 100 steps"));
		log.info(" queryByName :=>{}",repo.queryByName("Hibernate -in 100 steps"));
		log.info(" findByNameAndId :=>{}",repo.findByNameAndId("Hibernate -in 100 steps",1002l));
		log.info(" CountByName :=>{}",repo.countByName("Hibernate -in 100 steps"));
		log.info(" findByNameOrderByIdDesc :=>{}",repo.findByNameOrderByIdDesc("Hibernate -in 100 steps"));
		log.info(" customQuery :=>{}",repo.customQuery());
		log.info(" customNativeQuery :=>{}",repo.customNativeQuery());
		log.info(" customNamedQuery :=>{}",repo.customNamedQuery());
		
	}
}
