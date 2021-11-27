package com.ashish.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashish.jpa.JpaWithHibernateApplication;
import com.ashish.jpa.entity.Course;

@SpringBootTest(classes=JpaWithHibernateApplication.class)

/**
 * @author Ashish Gupta
 *
 */
class PerformanceTuningRepositoryTest {

	@Autowired
	EntityManager em;
	
	@Test
	@DisplayName("To create N+1 problen in hibernate.")
	@Transactional
	void createNplusOneProblem() {
	List<Course> courses = em.createNamedQuery("find_course_by_id",Course.class)
							.getResultList();
	 for(Course obj : courses) {
		 System.out.println(obj.getStudents());
		 if(obj.getStudents() != null && !obj.getStudents().isEmpty()) {
			 System.out.println(obj.getStudents().get(0).getPassport()); 
		 }
	 }
	}
	
	@Test
	@DisplayName("To solve N+1 problen in hibernate using entity graph.")
	@Transactional
	void solveNplusOneProblemusingEntityGraph() {
		EntityGraph<Course> entityGraph =em.createEntityGraph(Course.class);
		Subgraph<Object> addSubgraph = entityGraph.addSubgraph("students");
		addSubgraph.addSubgraph("passport");
	List<Course> courses = em.createNamedQuery("find_course_by_id",Course.class)
			.setHint("javax.persistence.loadgraph", entityGraph)
							.getResultList();
	 for(Course obj : courses) {
		 System.out.println(obj.getStudents());
		 if(obj.getStudents() != null && !obj.getStudents().isEmpty()) {
			 System.out.println(obj.getStudents().get(0).getPassport()); 
		 }
	 }
	}
	
	@Test
	@DisplayName("To solve N+1 problen in hibernate using Join Fetch.")
	@Transactional
	void solveNplusOneProblemusingJoinfetch() {
		List<Course> courses = em.createNamedQuery("find_course_by_id_join_fetch",Course.class)
				.getResultList();
		for(Course obj : courses) {
		System.out.println(obj.getStudents());
		if(obj.getStudents() != null && !obj.getStudents().isEmpty()) {
		 System.out.println(obj.getStudents().get(0).getPassport()); 
		}
}
	}
}


