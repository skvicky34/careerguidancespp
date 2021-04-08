package com.careerguidance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	List<Course> findByMinMarksGreaterThanEqualAndMinQualification(Double minMarks, String minQualification) throws DataNotFoundException;

	String getDescriptionById(Integer id);
	
//	@Query("from Course course where course.type =:type and course.name =:name")
//	Course findCourse(@Param("type") String type,@Param("name") String name);
}
