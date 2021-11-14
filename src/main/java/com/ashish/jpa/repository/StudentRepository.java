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
import com.ashish.jpa.entity.Passport;
import com.ashish.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public Student save(Student objStudent) {
		if(objStudent.getId() == null) {
			em.persist(objStudent);
		} else { 
			em.merge(objStudent);	
		} 
		
		return objStudent;
	}
	
	public void deleteById(Long id) {
		Student objStudent = findById(id);
		em.remove(objStudent);
	}
	// demo method 
	// flush : Synchronize the persistence context to the underlying database
	// detach : Remove the given entity from the persistence context
	// clear :  Clear the persistence context, causing all managed entities to become detached
	// refresh : Refresh the state of the instance from the database, overwriting changes made to the entity, if any.
	public void demoEntitymanager() {
		Student objStudent = new Student("RAM");
		em.persist(objStudent);
		em.flush();
		//em.detach(objStudent);
		//em.clear();
		
		Student objStudent1 = new Student("Lakshman");
		em.persist(objStudent1);
		em.flush();
		//em.detach(objStudent1);
		//em.clear();
		
		//em.clear();
		objStudent.setName("Ram- Updated");
		//em.flush();
		
		objStudent1.setName("Lakshman - Updated");
		
		em.refresh(objStudent);
		em.flush();
	}
	public void saveStudentWithPassport() {
		Passport objPassport = new Passport("E0MH004"); 
		em.persist(objPassport);
		
		Student objStudent =new Student("Bharat");
		objStudent.setPassport(objPassport);
		em.persist(objStudent);
	}
	
	public void insertStudentWithCourse(Student student,Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
		em.persist(course);
	}
}
