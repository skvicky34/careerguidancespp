package com.careerguidance.service;

import java.util.List;

import com.careerguidance.model.RecommendedCourseType;

public interface IQualificationService {
	
	public List<RecommendedCourseType> findAllCourseType(Integer totalMarks);

}
