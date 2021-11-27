package com.ashish.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.ashish.jpa.JpaWithHibernateApplication;
import com.ashish.jpa.entity.Course;
import com.ashish.jpa.repository.CourseRepository;

@SpringBootTest(classes=JpaWithHibernateApplication.class)

/**
 * @author Ashish Gupta
 *
 */
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	@DisplayName("To find Course by Id")
	void findById() {
		assertEquals("JPA -in 100 steps", courseRepository.findById(1001L).getName());
	}

	@Test
	@DirtiesContext
	@DisplayName("To delete Course by Id")
	void deleteById() {
		courseRepository.deleteById(1002l);
		assertNull(courseRepository.findById(1002l));
	}
	
	@Test
	@DirtiesContext
	@DisplayName("To create new Course")
	void save() {
		//to check save 
		Course objCourse =courseRepository.save(new Course("Junit -in 25 steps"));
		assertNotNull(objCourse.getId());	
	}
	
	@Test
	@DirtiesContext
	@DisplayName("To update existing Course")
	void update() {
		Course objCourse = courseRepository.findById(1002l);
		objCourse.setName("Hibernate -in 50 steps");
		courseRepository.save(objCourse);
		
		Course objUpdatedCourse = courseRepository.findById(1002l);
		assertEquals("Hibernate -in 50 steps", objUpdatedCourse.getName());
	}
	
	@Test
	@DirtiesContext
	@DisplayName("To call detach , flush, clear method") 
	void demoEntityManager() {
		courseRepository.demoEntitymanager();
	}
	
	@Test
	void secondLevelcacheTest() {
		Course objUpdatedCourse = courseRepository.findById(1002l);
		Course objUpdatedCourse1 = courseRepository.findById(1002l);
	}
}


