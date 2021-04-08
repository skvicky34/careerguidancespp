package com.careerguidance.service;

import java.util.List;

import com.careerguidance.model.AcademicDetails;
import com.careerguidance.model.Subject;

public interface AcademicDetailsService {

	AcademicDetails getAcademicDetailsById(Integer bookId);

	boolean updateAcademicDetails(AcademicDetails book);

	List<Subject> listSubjects();

	List<AcademicDetails> listAcademicDetails();

	void removeAcademicDetails(Integer id);

	void addAcademicDetails(AcademicDetails book); 

}
