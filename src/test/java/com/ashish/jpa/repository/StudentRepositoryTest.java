package com.ashish.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.jpa.JpaWithHibernateApplication;
import com.ashish.jpa.entity.Passport;
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
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	@DisplayName("To retrive Student detail with passport.")
	void retriveStudentwithPassport() {
		Student objStudent =studentRepository.findById(2001l);
		assertNotNull(objStudent);
		log.info("Student -> {}",objStudent);
		log.info("Passport -> {}",objStudent.getPassport());
	}
	
	@Test
	@Transactional
	@DisplayName("To Passport detail with associate student data.")
	void retrivePassportwithAssociateStudent() {
		Passport objPassport =em.find(Passport.class,4001l);
		assertNotNull(objPassport);
		log.info("Passport -> {}",objPassport);
		log.info("Student -> {}",objPassport.getStudent());
		//log.info("Passport -> {}" ,em.createQuery("from Passport",Passport.class).getResultList());
	}
	
	@Test
	@Transactional
	@DisplayName("To fetch student detail with all course")
	void retriveStudentWithAssociateCourse() {
		Student objStudent =em.find(Student.class,2001l);
		assertNotNull(objStudent);
		log.info("Student -> {}",objStudent);
		log.info("Course -> {}", objStudent.getCourses());
	}
}


