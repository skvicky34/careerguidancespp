package com.careerguidance.service;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Job;
import com.careerguidance.repositories.JobRepository;
/**
 * This class contains job service methods
 * @author Amarkant Gupta
 *
 */
@Service
public class JobServiceImpl implements IJobService {

	static final Logger LOGGER = Logger.getLogger(JobServiceImpl.class.getName());

	@Autowired
	JobRepository repository;

	@Override
	public List<Job> getJobs() throws DataNotFoundException {
		List<Job> jobs = (List<Job>) repository.findAll();
		if (jobs == null) {
			LOGGER.info("Jobs size: " + jobs.size());
			throw new DataNotFoundException("Data not found.");
		}
		return jobs;
	}

	@Override
	public List<Job> jobsBasedOnMarksAndQualification(Double minMarks, String minQualification)
			throws DataNotFoundException {
		return repository.findAllJobs(minMarks, minQualification);
	}

}
