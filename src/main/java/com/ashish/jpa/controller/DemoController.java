package com.ashish.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.jpa.repository.CourseRepository;

@RestController
public class DemoController {
	@Autowired
	private CourseRepository courseRepository;
	
	
	@RequestMapping("/second")
	public ResponseEntity<?> getCourses(){
		courseRepository.secondLevelcacheTest();
		courseRepository.secondLevelcacheTest();
		return new ResponseEntity<>(HttpStatus.OK);	
	} 
}
