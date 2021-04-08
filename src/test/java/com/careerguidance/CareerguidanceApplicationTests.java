package com.careerguidance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.careerguidance.dto.LoginDto;
import com.careerguidance.dto.UpdateProfileDto;
import com.careerguidance.dto.UserAcadmicDetails;
import com.careerguidance.dto.UserRegistrationDto;
import com.careerguidance.model.Course;
import com.careerguidance.model.Job;
import com.careerguidance.model.User;
import com.careerguidance.repositories.CourseRepository;
import com.careerguidance.repositories.JobRepository;
import com.careerguidance.service.ICourseService;
import com.careerguidance.service.IJobService;
import com.careerguidance.service.IUserService;
import com.careerguidance.util.PasswordEncryptor;

@SpringBootTest
class CareerguidanceApplicationTests {
	@Autowired
	ICourseService courseService;
	@Autowired
	IUserService userService;
	@Autowired
	IJobService jobService;
	@Autowired
	JobRepository repo;
	@Autowired
	CourseRepository courseRepo;

	static InetAddress ip;
	static String hostname;
	static PasswordEncryptor passwordEncryptor;

	@Test
	void contextLoads() {
	}

	// Test method to save the user details to database.
	@Test
	public void testSaveUser() throws UnknownHostException {
		UserRegistrationDto userdto = new UserRegistrationDto();
		userdto.setFirstName("Lara");
		userdto.setLastName("A");
		userdto.setEmail("lara@gmail.com");
		userdto.setMobileNo("879897890");
		userdto.setPassword("Lara@123");
		userdto.setConfirmPassword("Lara@123");
		userdto.setQualification("10th");
		userdto.setStatus("Appearing");
		userService.saveUser(userdto);
	}

	// Test method to get the user details from database.
	@Test
	public void testGetUser() {
		LoginDto logindto = new LoginDto();
		logindto.setEmail("mini@gmil.com");
		User user = userService.getUser(logindto);
		assertEquals("Mini", user.getFirstName());
	}

	// Test method to save the user details to database.
	@Test
	public void testSave() throws UnknownHostException {
		passwordEncryptor = new PasswordEncryptor();
		ip = InetAddress.getLocalHost();
		hostname = ip.getHostName();
		String secretKey = ip.toString();
		User user = new User();
		user.setId(1);
		user.setFirstName("Naveen");
		user.setLastName("A");
		user.setMobileNo("9874563210");
		user.setEmail("Naveen@gmail.com");
		user.setPassword(passwordEncryptor.encrypt("Naveen@123", secretKey));
		user.setQualification("12th");
		user.setStatus("Appearing");
		boolean isSuccessfull = userService.saveUser(user);
		assertEquals(true, isSuccessfull);
	}

	// Test method to update user academic details to database.
//	@Test
//	public void testUpdateUserAcademicDetails() {
//		UserAcadmicDetails academicdetails = new UserAcadmicDetails();
//		academicdetails.setUserId(1);
//		academicdetails.setAggregate(85d);
//		academicdetails.setEnglish(90);
//		academicdetails.setMaths(85);
//		academicdetails.setScience(92);
//		userService.updateUserAcadmicDetails(academicdetails);
//	}

	// Test method to get all the stored courses from database.
	@Test
	public void testGetCourses() {
		List<Course> courses = courseService.getCourses();
		courses.forEach(c -> System.out.println(c.getName()));
	}

	// Test method to get all the stored jobs from database.
	@Test
	public void testGetJobs() {
		List<Job> jobs = jobService.getJobs();
		jobs.forEach(j -> System.out.println(j.getName()));
	}

	// Test method to check the password encryption and decryption.
	@Test
	public void testPasswordEncryptDecrypt() {
		try {
			passwordEncryptor = new PasswordEncryptor();
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			System.out.println("Your current IP address : " + ip);
			System.out.println("Your current Hostname : " + hostname);
			String secretKey = ip.toString();
			System.out.println("secretkey" + secretKey);
			String originalpassword = "Saumya@123";
			String encryptedpassword = passwordEncryptor.encrypt(originalpassword, secretKey);
			System.out.println("Encrypted password=" + encryptedpassword);
			String decryptedpassword = passwordEncryptor.decrypt(encryptedpassword, secretKey);
			System.out.println("Decrypted password=" + decryptedpassword);
			assertEquals(originalpassword, decryptedpassword);
			// Assert.assertNotEquals(originalpassword, decryptedpassword);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	// Test method to update profile details to database.
	@Test
	public void testUpdateUser() {
		UpdateProfileDto updateProfileDto = new UpdateProfileDto();
		User user = userService.getUser(1);
		updateProfileDto.setUserId(user.getId());
		updateProfileDto.setEmail("john@gmail.com");
		updateProfileDto.setQualification("12th");
		updateProfileDto.setFirstName(user.getFirstName());
		updateProfileDto.setLastName(user.getLastName());
		updateProfileDto.setPassword(user.getPassword());
		updateProfileDto.setStatus("appearing");
		updateProfileDto.setMobileNo("9784563210");
		boolean updateStatus = userService.updateUser(updateProfileDto);
		assertEquals(true, updateStatus);
	}
	
	@Test
	public void testJobs() {
		
	List<Job> jobs =  repo.findAllJobs(45.0d, "10th");
	
	System.out.println("Size :"+jobs.size());
	
	for (Job job : jobs) {
		
		System.out.println("JOBBBB :"+job.getName());
		
	}
	}
	
	@Test
	public void testCourses() {
		
	List<Course> courses =  courseRepo.findByMinMarksGreaterThanEqualAndMinQualification(45.0d, "10th");
	
	System.out.println("Size :"+courses.size());
	
	for (Course course : courses) {
		
		System.out.println("Course :"+course.getName());
		
	}
	}
	
}
