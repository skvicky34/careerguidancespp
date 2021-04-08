package com.careerguidance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.careerguidance.model.UserAcademicSubject;

public interface UserAcademicSubjectRepo extends CrudRepository<UserAcademicSubject, Integer>{
	
	@SuppressWarnings("unchecked")
	UserAcademicSubject save(UserAcademicSubject userAcademicSubject);

}
