package com.ashish.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashish.jpa.entity.Course;
import com.ashish.jpa.entity.FullTimeEmployee;
import com.ashish.jpa.entity.PartTimeEmployee;
import com.ashish.jpa.entity.Review;
import com.ashish.jpa.entity.Student;
import com.ashish.jpa.repository.CourseRepository;
import com.ashish.jpa.repository.EmployeeRepository;
import com.ashish.jpa.repository.JPQLCourseRepository;
import com.ashish.jpa.repository.JPQLNamedQueriesCourseRepository;
import com.ashish.jpa.repository.NativeQueryCourseRepository;
import com.ashish.jpa.repository.StudentRepository;


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
	
	@Autowired
	StudentRepository studentrepo;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    /*
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
		
		log.info("        ----------------------------One to one mapping-----------------------------       ");
		studentrepo.saveStudentWithPassport();
		
		log.info("        ----------------------------One to Many mapping-----------------------------       ");
		
		List<Review> reviews =new ArrayList<>();
		reviews.add(new Review("5","Awesome content."));
		reviews.add(new Review("4","Higly informative."));
		repo.addReviewInCourse(1003l,reviews );
		
		log.info("        ---------------------------- Many to Many mapping-----------------------------       ");
		studentrepo.insertStudentWithCourse(new Student("Jill"), new Course("Micorservice in 50 steps."));
		*/
		
		log.info("        ---------------------------- Inheritance -----------------------------       ");
		employeeRepository.insert(new PartTimeEmployee("Jack",new BigDecimal(100)));
		employeeRepository.insert(new FullTimeEmployee("Jill",new BigDecimal(5000)));
		
		log.info("List of employee -> {}",employeeRepository.retriveAllEmployee());
		
	}
	
	

}
