package com.careerguidance.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.dto.UserCareerPathDto;
import com.careerguidance.model.Course;
import com.careerguidance.model.Job;
import com.careerguidance.model.RecommendedCourseType;
import com.careerguidance.model.User;
import com.careerguidance.model.UserCareerPath;
import com.careerguidance.repositories.CourseRepository;
import com.careerguidance.repositories.JobRepository;
import com.careerguidance.repositories.RecommendedCourseTypeRepository;
import com.careerguidance.repositories.UserCareerPathRepository;
import com.careerguidance.repositories.UserRepository;

/**
 * This class contains user career service methods
 * 
 * @author Amarkant Gupta
 *
 */
@Service
public class UserCareerPathServiceImpl implements IUserCareerPathService {

	@Autowired
	UserCareerPathRepository repository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	RecommendedCourseTypeRepository courseTypeRepository;

	static final Logger LOGGER = Logger.getLogger(UserCareerPathServiceImpl.class.getName());

	@Override
	public UserCareerPath saveUserCareerPath(UserCareerPathDto userCareerPathDto, User user) {
		UserCareerPath userCareerPath = null;
		userCareerPath = repository.findByUserId(user.getId());
		if (userCareerPath == null) {
			userCareerPath = new UserCareerPath();
			setUserCareerChoice(userCareerPathDto, userCareerPath);
			userCareerPath.setUser(user);
			return repository.save(userCareerPath);
		} else {
			setUserCareerChoice(userCareerPathDto, userCareerPath);
			return repository.save(userCareerPath);
		}

	}

	private void setUserCareerChoice(UserCareerPathDto userCareerPathDto, UserCareerPath userCareerPath) {
		Job job;
		RecommendedCourseType recommendedCourseType;
		userCareerPath.setType(userCareerPathDto.getType());
		userCareerPath.setName(userCareerPathDto.getName());
		userCareerPath.setDescription(userCareerPathDto.getDescription());
		LOGGER.info("USER CAREER CHOICE: "+userCareerPathDto.getUserChoice());
		if (userCareerPathDto.getUserChoice().equals("job")) {
			job = jobRepository.findJob(userCareerPathDto.getType(), userCareerPathDto.getName());
			userCareerPath.setJob(job);
			userCareerPath.setRecommendedCourseType(null);
		}

		if (userCareerPathDto.getUserChoice().equals("course")) {
			recommendedCourseType = courseTypeRepository.findCourseType(userCareerPath.getType());
			userCareerPath.setRecommendedCourseType(recommendedCourseType);
			userCareerPath.setJob(null);
		}
	}

}
