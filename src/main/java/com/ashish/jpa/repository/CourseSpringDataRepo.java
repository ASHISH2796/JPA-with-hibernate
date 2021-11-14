package com.ashish.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.jpa.entity.Course;

public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {

}
