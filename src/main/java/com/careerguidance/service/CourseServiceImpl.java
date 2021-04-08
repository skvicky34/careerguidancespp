package com.careerguidance.service;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Course;
import com.careerguidance.repositories.CourseRepository;
/**
 * This class contains course service methods
 * @author Amarkant Gupta
 *
 */
@Service
public class CourseServiceImpl implements ICourseService {

	static final Logger LOGGER = Logger.getLogger(CourseServiceImpl.class.getName());

	@Autowired
	CourseRepository repository;

	@Override
	public List<Course> getCourses() throws DataNotFoundException {
		List<Course> courses = (List<Course>) repository.findAll();
		if (courses == null) {
			LOGGER.info("Courses size: " + courses.size());
			throw new DataNotFoundException("Data not found.");
		}
		return courses;
	}

	@Override
	public List<Course> coursesBasedOnMarksAndQualification(Double minMarks, String minQualification)
			throws DataNotFoundException {
		return repository.findByMinMarksGreaterThanEqualAndMinQualification(minMarks, minQualification);
	}

}
