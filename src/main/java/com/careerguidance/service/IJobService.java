package com.careerguidance.service;

import java.util.List;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Job;

public interface IJobService {
	
	List<Job> getJobs()throws DataNotFoundException;
	
	List<Job> jobsBasedOnMarksAndQualification(Double minMarks, String minQualification)
			throws DataNotFoundException;

}
