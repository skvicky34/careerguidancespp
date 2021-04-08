package com.careerguidance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.careerguidance.model.UserCareerPath;

public interface UserCareerPathRepository extends CrudRepository<UserCareerPath, Integer> {
	
	UserCareerPath findByUserId(int id);

}
