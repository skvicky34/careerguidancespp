package com.careerguidance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{
	
	@Query("from Job job where job.minMarks <=:minMarks and job.minQualification=:minQualification")
	List<Job> findAllJobs(@Param("minMarks") Double minMarks, @Param("minQualification")String minQualification) throws DataNotFoundException;
	
	@Query("from Job job where job.type =:type")
	List<Job> findAllJobByType(@Param("type") String type);
	
	@Query("from Job job where job.type =:type and job.name =:name")
	Job findJob(@Param("type") String type,@Param("name")String name);

}
