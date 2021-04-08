package com.careerguidance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerguidance.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
	@Query("select u  from Subject u where u.id =:id")
	Subject findSubjectById(@Param("id") Integer id);
	
	@Query("select u.name from Subject u where u.id In(:subjectIds)")
	List<String> findAllSubject(@Param("subjectIds") List<Integer> subjectIds);

}
