package com.careerguidance.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.dto.AcademicDetailsDto;
import com.careerguidance.dto.ConfirmPasswordDto;
import com.careerguidance.dto.LoginDto;
import com.careerguidance.dto.SubjectDto;
import com.careerguidance.dto.UpdateProfileDto;
import com.careerguidance.dto.UserRegistrationDto;
import com.careerguidance.model.AcademicDetails;
import com.careerguidance.model.User;
import com.careerguidance.model.UserAcademicSubject;
import com.careerguidance.repositories.AcademicDetailsRepository;
import com.careerguidance.repositories.SubjectRepository;
import com.careerguidance.repositories.UserAcademicSubjectRepo;
import com.careerguidance.repositories.UserRepository;
import com.careerguidance.util.PasswordEncryptor;

/**
 * This service class contains user service methods.
 * 
 * @author Amarkant Gupta
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	UserRepository repository;
	
	@Autowired
	SubjectRepository  subjectRepository;

	@Autowired
	AcademicDetailsRepository academicDetailsRepository;
	
	@Autowired
	UserAcademicSubjectRepo userAcademicSubjectRepo;

	@Override
	public User saveUser(UserRegistrationDto registration) throws UnknownHostException {
		String encryptedPass = PasswordEncryptor.encrypt(registration.getPassword(), PasswordEncryptor.getSecretKey());

		User user = new User();

		List<User> getUserData = repository.findUserByEmailAndMobileNo(registration.getEmail(),
				registration.getMobileNo());
		if (getUserData.size() > 0) {
			user.setId(-1);
			return user;
		}

		user = new User(registration.getFirstName(), registration.getLastName(), registration.getEmail(), encryptedPass,
				registration.getMobileNo(), registration.getQualification(), registration.getStatus());
		return repository.save(user);
	}

	@Override
	public User getUser(LoginDto loginDto) {
		LOGGER.info("Email id: " + loginDto.getEmail());
		User user = repository.findUserByEmail(loginDto.getEmail());
		LOGGER.info("User details: " + user);
		return user;

	}

	@Override
	public User getUser(ConfirmPasswordDto confirmPasswordDto) {
		LOGGER.info("Email id: " + confirmPasswordDto.getEmail());
		User user = repository.findUserByEmail(confirmPasswordDto.getEmail());
		LOGGER.info("User details: " + user);
		return user;

	}

	@Override
	public User getUser(AcademicDetailsDto academicDetailsDto) {
		User user = repository.findById(academicDetailsDto.getUserId()).get();
		return user;

	}

	@Override
	public boolean saveUser(User user) throws UnknownHostException {
		boolean isSuccessfull = repository.existsById(user.getId());
		if (isSuccessfull) {
			repository.save(user);
			return true;
		}
		return false;
	}

	//	@Override
	//	public void updateUserAcadmicDetails(UserAcadmicDetails acadmicDetails) {
	//
	//		User user = repository.findById(acadmicDetails.getUserId()).get();
	//
	//		if(user!=null) {
	//			user.setAggregate(acadmicDetails.getAggregate());
	//			user.setScience(acadmicDetails.getScience());
	//			user.setMaths(acadmicDetails.getMaths());
	//			user.setEnglish(acadmicDetails.getEnglish());
	//			repository.save(user);
	//		} else {
	//			LOGGER.info("User doesn't exist. Id: "+acadmicDetails.getUserId());
	//			throw new InvalidInputDataException("User doesn't exist.");
	//		}
	//
	//	}

	@Override
	public User getUser(int userId) {
		User user = repository.findById(userId).get();
		return user;
	}

	// Method to update User profile details.
	@Override
	public boolean updateUser(UpdateProfileDto updateProfileDto) {
		User user = repository.findById(updateProfileDto.getUserId()).get();
		if (user != null) {
			user.setMobileNo(updateProfileDto.getMobileNo());
			user.setQualification(updateProfileDto.getQualification());
			user.setStatus(updateProfileDto.getStatus());
			repository.save(user);
			return true;
		}
		LOGGER.info("User doesn't exist. Id: " + updateProfileDto.getUserId());
		return false;
	}

	/*
	 * @Override public boolean updateUserAcadmicDetailsNew(Integer
	 * userId,List<SubjectDemo> subjectList) {
	 * 
	 * boolean result= false; AcademicDetails academicDetailsObj = new
	 * AcademicDetails(); List<AcademicDetails> resultList =
	 * repository.findAcademicDetailsByUserId(userId); List<SubjectDemo>
	 * newSubjectList = new ArrayList<SubjectDemo>(); boolean flag = false;
	 * 
	 * if(!resultList.isEmpty()) {
	 * 
	 * if user Already Exists and Subject Already present then we just need to
	 * update mark no need to create again
	 * 
	 * for(SubjectDemo subjectDemo :subjectList) { for(AcademicDetails
	 * academicDetails : resultList) {
	 * if(academicDetails.getSubjectName().equalsIgnoreCase(subjectDemo.
	 * getSubjectName())) { academicDetails.setMark(subjectDemo.getMark());
	 * academicDetailsRepository.save(academicDetails); flag = true; } }
	 * 
	 * check Flag for the subject which is newly added.
	 * 
	 * if(!flag) newSubjectList.add(subjectDemo); }
	 * 
	 * if user Already Exists But new Subject Added then we need to new record
	 * 
	 * 
	 * for(SubjectDemo obj :newSubjectList) { academicDetailsObj = new
	 * AcademicDetails(); academicDetailsObj.setMark(obj.getMark());
	 * academicDetailsObj.setSubjectName(obj.getSubjectName());
	 * academicDetailsObj.setUserId(userId);
	 * academicDetailsRepository.save(academicDetailsObj); }
	 * 
	 * } else {
	 * 
	 * if user Not Exists then we need to new record
	 * 
	 * for(SubjectDemo obj : subjectList) { academicDetailsObj = new
	 * AcademicDetails(); academicDetailsObj.setMark(obj.getMark());
	 * academicDetailsObj.setSubjectName(obj.getSubjectName());
	 * academicDetailsObj.setUserId(userId);
	 * academicDetailsRepository.save(academicDetailsObj); } } return result;
	 * 
	 * }
	 */

	@Override
	public Integer updateUserAcadmicDetails(AcademicDetailsDto academicDetailsDto) {
		boolean result = false;
		AcademicDetails academicDetailsObj = new AcademicDetails();
		AcademicDetails existingAcademic = repository.findAcademicDetailsByUserId(academicDetailsDto.getUserId());
		Integer academicDetailsId = null;

		if (existingAcademic != null) {

			/*
			 * if user Already Exists and Subject Already present then we just need to
			 * update mark no need to create again
			 */

			existingAcademic.setType(academicDetailsDto.getCareer());
			existingAcademic.setBoardName(academicDetailsDto.getBoard());
			existingAcademic.setTotalMarks(academicDetailsDto.getTotalMarks());
			academicDetailsRepository.save(existingAcademic);
			academicDetailsId = existingAcademic.getId();
		} else {

			/* if user Not Exists then we need to new record */
			academicDetailsObj = new AcademicDetails();
			academicDetailsObj.setType(academicDetailsDto.getCareer());
			academicDetailsObj.setBoardName(academicDetailsDto.getBoard());
			academicDetailsObj.setTotalMarks(academicDetailsDto.getTotalMarks());
			User user = getUser(academicDetailsDto);
			academicDetailsObj.setUser(user);
			AcademicDetails obj = academicDetailsRepository.save(academicDetailsObj);
			academicDetailsId = obj.getId();
		}
		return academicDetailsId;
	}

	@Override
	public void updateUserAcadmicDetailsSubjects(List<SubjectDto> subjectList, Integer academicDetailsId,
			Integer userId) {
		List<UserAcademicSubject> userAcademicSubjectList = repository.findAcademicDetailsSubjectByUserId(userId);
		boolean flag = false;
		UserAcademicSubject userAcademicSubjectObj = new UserAcademicSubject();
		List<SubjectDto> newSubjectList = new ArrayList<SubjectDto>();
		if(!userAcademicSubjectList.isEmpty()) {

			for(SubjectDto subjectDto :subjectList) { 
				for(UserAcademicSubject userAcademicSubject : userAcademicSubjectList) {
					
					/*System.out.println("userAcademicSubject.getSubject().getId()"+
					userAcademicSubject.getSubject().getId());
					
					System.out.println("subjectDemo.getSubjectid()"+subjectDto.getSubjectId());*/
					
					if(userAcademicSubject.getSubject().getId()== subjectDto.getSubjectId()) { 
						userAcademicSubject.setSubjectMarks(subjectDto.getMarks());
						userAcademicSubjectRepo.save(userAcademicSubject); 
						flag = true; 
					}
				}
				if(!flag) 
					newSubjectList.add(subjectDto); 
			}

			for(SubjectDto obj :newSubjectList) { 
				userAcademicSubjectObj = new UserAcademicSubject(); 
				userAcademicSubjectObj.setSubject(subjectRepository.findSubjectById(obj.getSubjectId()));
				userAcademicSubjectObj.setSubjectMarks(obj.getMarks());
				AcademicDetails existingAcademic = repository.findAcademicDetailsByUserId(userId);
				userAcademicSubjectObj.setAcademicDetails(existingAcademic);
				userAcademicSubjectRepo.save(userAcademicSubjectObj); 
			}

		}else {

			for(SubjectDto obj : subjectList) { 
				userAcademicSubjectObj = new UserAcademicSubject(); 
				userAcademicSubjectObj.setSubject(subjectRepository.findSubjectById(obj.getSubjectId()));
				userAcademicSubjectObj.setSubjectMarks(obj.getMarks());
				AcademicDetails existingAcademic = repository.findAcademicDetailsByUserId(userId);
				userAcademicSubjectObj.setAcademicDetails(existingAcademic);
				userAcademicSubjectRepo.save(userAcademicSubjectObj); 
			}


		}
	}
}
