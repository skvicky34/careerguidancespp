package com.careerguidance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.careerguidance.model.Course;
import com.careerguidance.model.Otp;

public interface OtpRepository extends CrudRepository<Course, Integer> {

	Otp save(Otp otpObj);

}
