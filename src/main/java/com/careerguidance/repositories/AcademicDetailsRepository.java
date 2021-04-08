package com.careerguidance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.careerguidance.model.AcademicDetails;
import com.careerguidance.model.UserAcademicSubject;

public interface AcademicDetailsRepository extends CrudRepository<AcademicDetails, Integer>{
	
	@SuppressWarnings("unchecked")
	AcademicDetails save(AcademicDetails academicDetails);
	
	@SuppressWarnings("unchecked")
	boolean save(UserAcademicSubject userAcademicSubject);

}
