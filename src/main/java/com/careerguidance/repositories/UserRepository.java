package com.careerguidance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerguidance.model.AcademicDetails;
import com.careerguidance.model.Otp;
import com.careerguidance.model.User;
import com.careerguidance.model.UserAcademicSubject;

/**
 * 
 * @author Amarkant Gupta
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u  from User u where u.email =:email")
	User findUserByEmail(@Param("email") String email);
	
	@Query("select u  from Otp u where u.email =:email")
	Otp findOtpByEmail(@Param("email") String email);
	
	@Query("from AcademicDetails academicDetails where academicDetails.user.id=:userId ") 
	AcademicDetails findAcademicDetailsByUserId(@Param("userId") Integer userId);
	
	@Query("from UserAcademicSubject userAcademicSubject where userAcademicSubject.academicDetails.user.id=:userId ") 
	List<UserAcademicSubject> findAcademicDetailsSubjectByUserId(@Param("userId") Integer userId);

	List<User> findUserByEmailAndMobileNo(String email, String mobileNo);

}
