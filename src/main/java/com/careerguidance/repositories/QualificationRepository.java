package com.careerguidance.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.careerguidance.model.Course;
import com.careerguidance.model.Qualification;

public interface QualificationRepository extends CrudRepository<Qualification, Integer> {
	
	@Query("from Course course where course.type =:type and course.name =:name")
	Course findCourse(@Param("type") String type,@Param("name") String name);

}
