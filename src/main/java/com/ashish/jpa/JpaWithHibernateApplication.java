package com.ashish.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashish.jpa.entity.Course;
import com.ashish.jpa.repository.CourseRepository;


@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    repo.save(new Course("Spring Framework -in 100 steps"));
		Course obj =repo.findById(1001L);
		log.info(obj.toString());
		
		//repo.deleteById(1001l);
		
		repo.demoEntitymanager();
	  
	}
	
	

}
