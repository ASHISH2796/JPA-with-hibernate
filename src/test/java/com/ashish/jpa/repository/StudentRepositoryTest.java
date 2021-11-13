package com.ashish.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.jpa.JpaWithHibernateApplication;
import com.ashish.jpa.entity.Student;

@SpringBootTest(classes=JpaWithHibernateApplication.class)

/**
 * @author Ashish Gupta
 *
 */
class StudentRepositoryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@Transactional
	@DisplayName("To retrive Student detail with passport.")
	void retriveStudentwithPassport() {
		Student objStudent =studentRepository.findById(2001l);
		assertNotNull(objStudent);
		log.info("Student -> {}",objStudent);
		log.info("Passport -> {}",objStudent.getPassport());
	}
}


