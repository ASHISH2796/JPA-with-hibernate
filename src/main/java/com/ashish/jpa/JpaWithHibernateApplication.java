package com.ashish.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashish.jpa.entity.Course;
import com.ashish.jpa.repository.CourseRepository;
import com.ashish.jpa.repository.JPQLCourseRepository;
import com.ashish.jpa.repository.JPQLNamedQueriesCourseRepository;
import com.ashish.jpa.repository.NativeQueryCourseRepository;


@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repo;
	
	@Autowired
	JPQLCourseRepository jpqlrepo;
	
	@Autowired
	JPQLNamedQueriesCourseRepository jpqlNamedQueryrepo;
	
	@Autowired
	NativeQueryCourseRepository nativeQueryrepo;
	
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
		
		log.info("        ---------------------------------------------------------       ");
		jpqlrepo.findByid();
		jpqlrepo.findById_type();
		jpqlrepo.findById_where();
		
		log.info("        ----------------------------Named Query -----------------------------       ");
		jpqlNamedQueryrepo.findByid();
		jpqlNamedQueryrepo.findById_type();
		jpqlNamedQueryrepo.findById_where();
		
		log.info("        ----------------------------Native Query -----------------------------       ");
		nativeQueryrepo.findByid();
		nativeQueryrepo.findById_named_param(1001l);
		nativeQueryrepo.findById_positional_param(1001l);
		nativeQueryrepo.updateCourseById();
		
	}
	
	

}
