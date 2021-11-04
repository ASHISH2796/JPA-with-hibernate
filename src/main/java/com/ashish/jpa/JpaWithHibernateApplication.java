package com.ashish.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashish.jpa.entity.Course;
import com.ashish.jpa.repository.CourseRepository;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner{

	@Autowired
	CourseRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repo.save(new Course("JPA -in 100 steps"));
	  System.out.println(repo.findById(1001L));
		
	}
	
	

}
