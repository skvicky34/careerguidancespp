package com.careerguidance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.careerguidance.model.RecommendedCourseType;

public interface RecommendedCourseTypeRepository extends CrudRepository<RecommendedCourseType, Integer> {

	
	@Query("from RecommendedCourseType recommendedCourseType where recommendedCourseType.minMarks<=:totalMarks ") 
	List<RecommendedCourseType> findAllCourseType(@Param("totalMarks")Integer totalMarks);
	
	@Query("from RecommendedCourseType recommendedCourseType where recommendedCourseType.name=:name")
	RecommendedCourseType findCourseType(@Param("name") String name);

}
