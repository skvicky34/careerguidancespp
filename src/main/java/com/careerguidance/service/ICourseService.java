package com.careerguidance.service;

import java.util.List;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Course;

public interface ICourseService {
	
	List<Course> getCourses()throws DataNotFoundException;
	
	List<Course> coursesBasedOnMarksAndQualification(Double minMarks, String minQualification) throws DataNotFoundException;

}
