package com.ashish.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashish.jpa.entity.Course;

public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {
   
	List<Course> findByName(String name);
	List<Course> queryByName(String name);
	List<Course> findByNameAndId(String name,Long id);
	int countByName(String name);
	
	List<Course> findByNameOrderByIdDesc(String name);
	
	void deleteByName(String name);
	
	@Query("Select c from Course c")
	List<Course> customQuery();
	
	@Query(value="Select * from course c",nativeQuery=true)
	List<Course> customNativeQuery();
	
	@Query(name="find_course_by_id")
	List<Course> customNamedQuery();
}
