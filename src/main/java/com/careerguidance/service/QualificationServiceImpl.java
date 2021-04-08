package com.careerguidance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.model.RecommendedCourseType;
import com.careerguidance.repositories.RecommendedCourseTypeRepository;

/**
 * This class contains Qualification Service methods
 * 
 * @author Sandeep Kumar
 *
 */
@Service
public class QualificationServiceImpl implements IQualificationService{
	
	@Autowired
	RecommendedCourseTypeRepository recommendedCourseTypeRepository;

	@Override
	public List<RecommendedCourseType> findAllCourseType(Integer totalMarks) {
		List<RecommendedCourseType> courseTypes= recommendedCourseTypeRepository.findAllCourseType(totalMarks);
		return courseTypes;
	}
	
	
}
