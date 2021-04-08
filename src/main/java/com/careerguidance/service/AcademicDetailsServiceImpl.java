package com.careerguidance.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.careerguidance.model.AcademicDetails;
import com.careerguidance.model.Subject;
import com.careerguidance.repositories.AcademicDetailsRepository;
import com.careerguidance.repositories.SubjectRepository;


@Service
public class AcademicDetailsServiceImpl implements AcademicDetailsService {
	
	static final Logger LOGGER = Logger.getLogger(AcademicDetailsServiceImpl.class.getName());

	
	@Autowired
	AcademicDetailsRepository repository;
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public AcademicDetails getAcademicDetailsById(Integer academicDetailsById) {
		AcademicDetails academicDetails = repository.findById(academicDetailsById).get();	
		return academicDetails;
	}

	@Override
	public boolean updateAcademicDetails(AcademicDetails academicDetailsObj) {
		AcademicDetails academicDetails = repository.findById(academicDetailsObj.getId()).get();
		if (academicDetails != null) {
//			academicDetails.setMark(academicDetailsObj.getMark());
//			academicDetails.setSubjectName(academicDetailsObj.getSubjectName());
			repository.save(academicDetails);
			return true;
		}
		return false;
		
		
	}

	@Override
	public List<Subject> listSubjects() {
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();
		return subjects;
	}

	@Override
	public List<AcademicDetails> listAcademicDetails() {
		List<AcademicDetails> academicDetails = (List<AcademicDetails>) repository.findAll();
		return academicDetails;
	}

	@Override
	public void removeAcademicDetails(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void addAcademicDetails(AcademicDetails academicDetails) {
		repository.save(academicDetails);
	}
}
