package com.careerguidance.controller;

import static com.careerguidance.util.ICareerConstants.ACADMIC_SUCCESS_MSG;
import static com.careerguidance.util.ICareerConstants.DB_ERR_MSG;
import static com.careerguidance.util.ICareerConstants.INVALID_OTP;
import static com.careerguidance.util.ICareerConstants.LOGIN_ERR_MSG;
import static com.careerguidance.util.ICareerConstants.PASSWORD_CHANGE_ERROR_MSG;
import static com.careerguidance.util.ICareerConstants.PASSWORD_CHANGE_OLD_ERROR_MSG;
import static com.careerguidance.util.ICareerConstants.PASSWORD_CHANGE_SUCCESS_MSG;
import static com.careerguidance.util.ICareerConstants.PASSWORD_DIFFERENT_ERROR_MSG;
import static com.careerguidance.util.ICareerConstants.PROFILE_UPDATE_FAIL_MSG;
import static com.careerguidance.util.ICareerConstants.PROFILE_UPDATE_SUCCESS_MSG;
import static com.careerguidance.util.ICareerConstants.USER_ALREADY_EXIST_MSG;
import static com.careerguidance.util.ICareerConstants.USER_NOT_EXIST_MSG;
import static com.careerguidance.util.ICareerConstants.USER_REG_SUCCESS_MSG;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.careerguidance.dto.AcademicDetailsDto;
import com.careerguidance.dto.ConfirmPasswordDto;
import com.careerguidance.dto.LoginDto;
import com.careerguidance.dto.OtpDto;
import com.careerguidance.dto.SubjectDto;
import com.careerguidance.dto.UpdateProfileDto;
import com.careerguidance.dto.UserCareerPathDto;
import com.careerguidance.dto.UserRegistrationDto;
import com.careerguidance.model.ExaminationBoard;
import com.careerguidance.model.Job;
import com.careerguidance.model.Otp;
import com.careerguidance.model.RecommendedCourse;
import com.careerguidance.model.RecommendedCourseType;
import com.careerguidance.model.Subject;
import com.careerguidance.model.User;
import com.careerguidance.repositories.JobRepository;
import com.careerguidance.repositories.SubjectRepository;
import com.careerguidance.repositories.UserRepository;
import com.careerguidance.service.AcademicDetailsService;
import com.careerguidance.service.ICourseService;
import com.careerguidance.service.IExaminationBoardService;
import com.careerguidance.service.IJobService;
import com.careerguidance.service.IUserCareerPathService;
import com.careerguidance.service.IUserService;
import com.careerguidance.service.QualificationServiceImpl;
import com.careerguidance.service.SendMailService;
import com.careerguidance.util.PasswordEncryptor;

/**
 *
 * This controller class contains GET, POST, PUT and DELETE methods for the
 * CareerGuidance.
 * 
 * @author Amarkant Gupta
 *
 */
@Controller
public class CareerGuidanceController {

	static final Logger LOGGER = Logger.getLogger(CareerGuidanceController.class.getName());

	@Autowired
	IUserService userService;

	@Autowired
	IJobService jobService;

	@Autowired
	ICourseService courseService;

	@Autowired
	SendMailService sendMailService;

	@Autowired
	IUserCareerPathService userCareerPathService;

	@Autowired
	UserRepository repository;

	@Autowired
	AcademicDetailsService academicDetailsService;

	@Autowired
	IExaminationBoardService examinationBoardService;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	QualificationServiceImpl qualificationServiceImpl;
	
	@Autowired
	JobRepository jobRepository;

	List<Subject> subjects = null;
	List<ExaminationBoard> boards = null;
	List<RecommendedCourseType> courseTypes = null;
	List<Job> jobList =null;

	@RequestMapping("/index")
	public String index() {
		LOGGER.info("Redirected to index page");
		return "index";

	}

	@RequestMapping("/display")
	public String display() {
		LOGGER.info("Redirected to display page");
		return "display";

	}

	@RequestMapping("/userRegistration")
	public String registration() {
		LOGGER.info("Redirected to userRegistration page");
		return "userRegistration";

	}

	@RequestMapping("/login")
	public String login() {
		LOGGER.info("Redirected to login page");
		return "login";

	}

	@RequestMapping("/home")
	public String home() {
		LOGGER.info("Redirected to home page");
		return "home";

	}

	/**
	 * This method is responsible to register new user
	 * 
	 * @param registration
	 * @param modelmap
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/register")
	public String userRegistration(@ModelAttribute("registration") UserRegistrationDto registration, ModelMap modelmap)
			throws ServletException, IOException {
		LOGGER.info("UserRegistrationDto: " + registration.getFirstName());
		if (registration.getPassword().equals(registration.getConfirmPassword())) {
			User user = userService.saveUser(registration);

			if (user != null) {
				if (user.getId() == -1) {
					LOGGER.info("UserRegistrationDto: FAILED");
					modelmap.addAttribute("errorMsg", USER_ALREADY_EXIST_MSG);
					return "userRegistration";
				} else {
					LOGGER.info("UserRegistrationDto: PASS");
					modelmap.addAttribute("successMsg", USER_REG_SUCCESS_MSG);
					return "login";
				}
			}
			LOGGER.info("UserRegistrationDto: FAILED");
			modelmap.addAttribute("errorMsg", DB_ERR_MSG);
			return "userRegistration";
		} else {
			LOGGER.info("UserRegistrationDto: FAILED");
			modelmap.addAttribute("errorMsg", PASSWORD_DIFFERENT_ERROR_MSG);
			return "userRegistration";
		}
	}

	/**
	 * This method validate user credential and if success then redirect to home
	 * page
	 * 
	 * @param loginDto
	 * @param modelmap
	 * @param session
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("loginDto") LoginDto loginDto, ModelMap modelmap, HttpSession session)
			throws UnknownHostException {
		String originalPass = "";
		LOGGER.info("Email: " + loginDto.getEmail() + " Password: " + loginDto.getPassword());
		User user = userService.getUser(loginDto);
		if (user != null) {
			originalPass = PasswordEncryptor.decrypt(user.getPassword(), PasswordEncryptor.getSecretKey());
			if (user.getEmail().equals(loginDto.getEmail()) && originalPass != null
					&& originalPass.equals(loginDto.getPassword())) {
				subjects = academicDetailsService.listSubjects();
				boards = examinationBoardService.getBoardsName();
				modelmap.addAttribute("userId", user.getId());
				modelmap.addAttribute("subjects", subjects);
				modelmap.addAttribute("qualification", user.getQualification());
				modelmap.addAttribute("status", user.getStatus());
				modelmap.addAttribute("boards", boards);
				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getFirstName());
				return "home";
			}
		}

		modelmap.addAttribute("loginErrMsg", LOGIN_ERR_MSG);
		return "login";
	}

	/**
	 * This method will redirect to OTP page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/OtpValidation", method = RequestMethod.GET)
	public String showOtpPage() {
		LOGGER.info("Redirected to Otp page");
		return "OtpValidation";

	}

	/**
	 * This method will validate user based on OTP before changing password
	 * 
	 * @param otpDto
	 * @param modelmap
	 * @param email
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/OtpValidation-New", method = RequestMethod.POST)
	public String getOtp(@ModelAttribute("OtpDto") OtpDto otpDto, ModelMap modelmap, @RequestParam String email)
			throws UnknownHostException {
		LOGGER.info("Redirected to Otp Enter page");
		String otp = "";
		boolean isSuccessfull = false;
		Otp otpObj = null;
		User user = repository.findUserByEmail(email);
		if (user != null) {
			try {
				otp = sendMailService.generateOtp();

				Otp otpRecord = repository.findOtpByEmail(email);
				if (otpRecord == null) {
					otpObj = sendMailService.saveOtp(email, otp);
				} else {
					otpRecord.setOtp(otp);
					otpObj = sendMailService.updateOtp(otpRecord);
				}
				if (otpObj != null) {
					sendMailService.sendOtp(otp, email);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			LOGGER.info("User is not regitered with this mail id");
			modelmap.addAttribute("errorMsg", USER_NOT_EXIST_MSG);
			return "OtpValidation";
		}

		modelmap.addAttribute("email", email);
		modelmap.addAttribute("otp", otp);
		return "OtpValidation-New";

	}

	/**
	 * 
	 * @param otpDto
	 * @param modelmap
	 * @param email
	 * @param id_otp
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/validationOtp", method = RequestMethod.POST)
	public String validateOtp(@ModelAttribute("OtpDto") OtpDto otpDto, ModelMap modelmap, @RequestParam String email,
			@RequestParam String id_otp) throws UnknownHostException {
		LOGGER.info("Redirected to Otp Validate page");
		String otp = "";
		boolean isSuccessfull = false;

		Otp otpRecord = repository.findOtpByEmail(email);
		if (otpRecord != null) {
			if (!otpRecord.getOtp().equals(id_otp)) {
				LOGGER.info("Otp is not valid try again");
				modelmap.addAttribute("email", email);
				modelmap.addAttribute("otp", otp);
				modelmap.addAttribute("errorMsg", INVALID_OTP);
				return "OtpValidation-New";
			}
		}
		modelmap.addAttribute("email", email);
		modelmap.addAttribute("otp", id_otp);
		return "forgot-password";

	}

	/**
	 * This method contains forgot-password validation logic
	 * 
	 * @param modelmap
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String showForgotPasswordPage(ModelMap modelmap, @RequestParam String email) {
		LOGGER.info("Redirected to forgot password page");
		modelmap.addAttribute("email", email);
		return "forgot-password";

	}

	/**
	 * 
	 * @param confirmPasswordDto
	 * @param modelmap
	 * @param email
	 * @param password
	 * @param confpassword
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public String forgotPasswordEntry(@ModelAttribute("confirmPasswordDto") ConfirmPasswordDto confirmPasswordDto,
			ModelMap modelmap, @RequestParam String email, @RequestParam String password,
			@RequestParam String confpassword) throws UnknownHostException {
		String newPassword = "";
		boolean isSuccessfull;
		if (password.equals(confpassword)) {
			LOGGER.info("Email: " + email);
			User user = userService.getUser(confirmPasswordDto);
			if (user != null) {
				if (!(password
						.equals(PasswordEncryptor.decrypt(user.getPassword(), PasswordEncryptor.getSecretKey())))) {
					newPassword = PasswordEncryptor.encrypt(password, PasswordEncryptor.getSecretKey());
					user.setPassword(newPassword);
					isSuccessfull = userService.saveUser(user);
					if (isSuccessfull) {
						LOGGER.info("Password Change: PASS");
						modelmap.addAttribute("successMsg", PASSWORD_CHANGE_SUCCESS_MSG);
						return "login";
					}
				}

				LOGGER.info("Password Change:FAILED");
				modelmap.addAttribute("email", email);
				modelmap.addAttribute("errorMsg", PASSWORD_CHANGE_OLD_ERROR_MSG);
				return "forgot-password";
			}
		}
		LOGGER.info("Password Change:FAILED");
		modelmap.addAttribute("email", email);
		modelmap.addAttribute("errorMsg", PASSWORD_CHANGE_ERROR_MSG);
		return "forgot-password";
	}

	/**
	 * This method is responsible to update user Academic details in DB.
	 * 
	 * @param acadmicDetails
	 * @param modelmap
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/userAcadmic")
	public String updateUserAcadmicDetails(@ModelAttribute("academicDetailsDto") AcademicDetailsDto academicDetailsDto,
			ModelMap modelmap, HttpSession session) throws ServletException, IOException {

		System.out.println("map" + academicDetailsDto.getDemo());
		List<SubjectDto> subjectList = getSubjectList(academicDetailsDto.getDemo());
		List<Integer> subjectIds = new ArrayList<Integer>();

		User user = userService.getUser(academicDetailsDto);
		
		jobList = (List<Job>) jobService.jobsBasedOnMarksAndQualification(academicDetailsDto.getTotalMarks(), user.getQualification());

		Integer academicDetailsId = userService.updateUserAcadmicDetails(academicDetailsDto);
		userService.updateUserAcadmicDetailsSubjects(subjectList, academicDetailsId, user.getId());

		/*
		 * passing top 3 subjects id's and getting subjects names
		 */

		List<String> subjects = getHighestSubjectsMarkList(subjectList, subjectIds);

		LOGGER.info(ACADMIC_SUCCESS_MSG);
		modelmap.addAttribute("acadmicSuccessMsg", ACADMIC_SUCCESS_MSG);
		modelmap.addAttribute("userId", user.getId());
		modelmap.addAttribute("userName", user.getFirstName());
		modelmap.addAttribute("subjects", subjects);
		modelmap.addAttribute("jobs", jobList);
		modelmap.addAttribute("userChoice", academicDetailsDto.getCareer());
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getFirstName());

		if (academicDetailsDto.getCareer().equalsIgnoreCase("course")) {
			courseTypes = qualificationServiceImpl.findAllCourseType(academicDetailsDto.getTotalMarks().intValue());
			modelmap.addAttribute("courseTypes", courseTypes);
			return "courses";
		} else {
			return "jobs";
		}
	}

	private List<String> getHighestSubjectsMarkList(List<SubjectDto> subjectList, List<Integer> subjectIds) {
		Collections.sort(subjectList, new Comparator<SubjectDto>() {
			@Override
			public int compare(SubjectDto o1, SubjectDto o2) {
				return o2.getMarks().compareTo(o1.getMarks());
			}
		});

		for(int sid=0;sid<subjectList.size();sid++) {
            subjectIds.add(subjectList.get(sid).getSubjectId());
        }
		
		List<String> subjects = subjectRepository.findAllSubject(subjectIds);

		for (String subobj : subjects) {

			System.out.print("Subjects == >> " + subobj);
		}
		return subjects;
	}

	/**
	 * 
	 * @param modelmap
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showProfile(ModelMap modelmap, HttpSession session) throws ServletException, IOException {
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		User user = userService.getUser(userId);
		modelmap.addAttribute("user", user);
		modelmap.addAttribute("userName", userName);
		LOGGER.info("Redirected to update profile page");
		return "profile";
	}

	/**
	 * This method contains user profile update logics.
	 * 
	 * @param updateProfileDto
	 * @param modelmap
	 * @param session
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("updateProfileDto") UpdateProfileDto updateProfileDto,
			ModelMap modelmap, HttpSession session) throws UnknownHostException {
		boolean isUpdateSuccessful = userService.updateUser(updateProfileDto);
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		if (isUpdateSuccessful) {
			LOGGER.info("Profile Update : PASS");
			LOGGER.info("Redirected to home page");
			String qualification = updateProfileDto.getQualification();
			modelmap.addAttribute("userId", userId);
			modelmap.addAttribute("userName", userName);
			modelmap.addAttribute("successMsg", PROFILE_UPDATE_SUCCESS_MSG);
			return "home";
		}
		LOGGER.info("Profile Update:FAILED");
		LOGGER.info("Redirected to profile page");
		modelmap.addAttribute("userId", userId);
		modelmap.addAttribute("userName", userName);
		modelmap.addAttribute("errorMsg", PROFILE_UPDATE_FAIL_MSG);
		return "profile";
	}

	/**
	 * This method is responsible to persist user career path data into DB.
	 * 
	 * @param userCareerPath
	 * @param modelmap
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/saveCareerPath")
	public String saveUserAcadmicDetails(@ModelAttribute("userCareerPath") UserCareerPathDto userCareerPath,
			ModelMap modelmap, HttpSession session) throws ServletException, IOException {
		int userId = (int) session.getAttribute("userId");
		LOGGER.info("ID : " + userId);
		User user = userService.getUser(userId);
//		 userCareerPath.setUser(user);
		userCareerPath.setDescription(userCareerPath.getDescription().replaceAll("#"," "));
		userCareerPathService.saveUserCareerPath(userCareerPath, user);
		modelmap.addAttribute("userId", userId);
		modelmap.addAttribute("user", user);
		modelmap.addAttribute("userCareerData", userCareerPathService.saveUserCareerPath(userCareerPath, user));
		modelmap.addAttribute("careerSaveMsg", "Career path saved successfully.");
		return "display";

	}

	/**
	 * This method is used to destroy the session once the user logout.
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private static List<SubjectDto> getSubjectList(String str) {
		List<SubjectDto> subjectList = new ArrayList<>();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = new JSONObject(str);
			System.out.println(jsonObject.get("myMap"));
		} catch (JSONException err) {
			LOGGER.info("Error");
		}

		String strNew = null;
		try {
			strNew = jsonObject.get("myMap").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String[] entrySet = strNew.split(",");
		for (String entry : entrySet) {
			SubjectDto obj = new SubjectDto();
			String[] keyValue = entry.split(":");
			obj.setSubjectId(Integer.parseInt(keyValue[0].trim().replaceAll("[{,}\"]", "")));
			obj.setMarks(keyValue[1].trim().replaceAll("[{,}\"]", ""));
			subjectList.add(obj);
		}
		return subjectList;
	}

	@RequestMapping("/subjectList")
	public void getSubjectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String board = request.getParameter("board");
			response.getWriter().write("<select>");
			Set<Subject> subjectList = null;
			for (ExaminationBoard examBoard : boards) {
				if (examBoard.getName().equals(board)) {
					subjectList = examBoard.getSubjects();
				}
			}
			for (Subject subject : subjectList) {

				response.getWriter().write("<option value=" + subject.getId() + ">" + subject.getName() + "</option>");
			}
			response.getWriter().write("</select>");

		}
	}

	@RequestMapping("/courseList")
	public void getCourseList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String courseType = request.getParameter("type");
			Set<RecommendedCourse> recommendedCourses = null;
			for (RecommendedCourseType type : courseTypes) {
				System.out.println("courseTypes.get(0).getDescription()"+courseTypes.get(0).getDescription());
				if (type.getName().equals(courseType)) {
					recommendedCourses = type.getRecommendedCourses();
					response.getWriter().write(
							"<div style=\"height:100px;width:500px;overflow:auto;scrollbar-base-color:gold;font-family:sans-serif;padding:5px;\">"
									+ type.getDescription() + "</div>");
				}

			}
			String courseName = null;
			String defaultCourse = "";
			response.getWriter().write("<select id=\"courseSelName\" name=\"name\" onchange=\"onCourseSelect()\">");

			for (RecommendedCourse course : recommendedCourses) {
				if(defaultCourse.equalsIgnoreCase("")) {
					defaultCourse = course.getName();
				}
				courseName = course.getName();
				response.getWriter().write("<option value=" + course.getName() + ">" + course.getName() + "</option>");
			}
			response.getWriter().write("</select>");

			for (RecommendedCourse course : recommendedCourses) {
				if (course.getName().equals(defaultCourse)) {
					response.getWriter().write(
							"<div style=\"height:80px;width:650px;font-family:sans-serif;padding:5px;\">"
									+ course.getDescription() + "</div>");
					response.getWriter().write("<input type='hidden' name=\"description\" value="+ course.getDescription().replaceAll("\\s+","#") +"/>");
					courseName = null;
				}
			}

		}
	}
	
	
	@RequestMapping("/courseDescList")
	public void getcourseDescList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String courseType = request.getParameter("type");
			String courseId = request.getParameter("fname");
			Set<RecommendedCourse> recommendedCourses = null;
			for (RecommendedCourseType type : courseTypes) {
				System.out.println("courseTypes.get(0).getDescription()"+courseTypes.get(0).getDescription());
				if (type.getName().equals(courseType)) {
					recommendedCourses = type.getRecommendedCourses();
					response.getWriter().write(
							"<div style=\"height:100px;width:500px;overflow:auto;scrollbar-base-color:gold;font-family:sans-serif;padding:5px;\">"
									+ type.getDescription() + "</div>");
//					response.getWriter().write("<input type='hidden' name='description' value="+ type.getDescription() +"/>");
				}

			}
			String courseName = null;
			String defaultCourse = "";
			response.getWriter().write("<select id=\"courseSelName\" name=\"name\" onchange=\"onCourseSelect()\">");

			for (RecommendedCourse course : recommendedCourses) {
				if(defaultCourse.equalsIgnoreCase("")) {
					defaultCourse = course.getName();
				}
				courseName = course.getName();
				if (course.getName().equalsIgnoreCase(courseId)) {
					response.getWriter().write("<option selected value=" + course.getName() + ">" + course.getName() + "</option>");
				}else {
					response.getWriter().write("<option value=" + course.getName() + ">" + course.getName() + "</option>");
				}
				
			}
			response.getWriter().write("</select>");

			for (RecommendedCourse course : recommendedCourses) {
				if (course.getName().equalsIgnoreCase(courseId)) {
					response.getWriter().write(
							"<div style=\"height:80px;width:650px;font-family:sans-serif;padding:5px;\">"
									+ course.getDescription() + "</div>");
					response.getWriter().write("<input type='hidden' name=\"description\" value="+ course.getDescription().replaceAll("\\s+","#") +"/>");
					courseName = null;
				}
			}

		}
	}


	@RequestMapping("/jobList")
	public void getJobList(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelmap) throws IOException {
		response.setContentType("text/html");
		String description = null;
		try (PrintWriter out = response.getWriter()) {
			String type = request.getParameter("type");
			System.out.println("JOBTYPE : "+type);
			response.getWriter().write("<select>");
			for (Job job : jobList) {
				if (job.getType().equals(type)) {
					if(description == null)
					description = job.getDescription();
					response.getWriter().write("<option value=" + job.getName() + ">" + job.getName() + "</option>");
				}

			}
			response.getWriter().write("</select>");
			response.getWriter().write(description);
			modelmap.addAttribute("description", description);
		}
	}

	@RequestMapping("/getPostDesc")
	public void getPostDescription(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelmap) throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("postName");
			String type = request.getParameter("fname");
			String description = null;
			for (Job job : jobList) {
				if (job.getName().equalsIgnoreCase(name)) {
					description = job.getDescription();
				}

			}
			response.getWriter().write(description);
			modelmap.addAttribute("description", description);
		}
	}
	
	
	@RequestMapping("/resendOtp")
	public void resendOtp(HttpServletRequest request, HttpServletResponse response, ModelMap modelmap)
			throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			LOGGER.info("Redirected to Otp Enter page from resend otp");
			String otp = "";
			boolean isSuccessfull = false;
			Otp otpObj = null;
			User user = repository.findUserByEmail(email);
			if (user != null) {
				try {
					otp = sendMailService.generateOtp();

					Otp otpRecord = repository.findOtpByEmail(email);
					if (otpRecord == null) {
						otpObj = sendMailService.saveOtp(email, otp);
					} else {
						otpRecord.setOtp(otp);
						otpObj = sendMailService.updateOtp(otpRecord);
					}
					if (otpObj != null) {
						sendMailService.sendOtp(otp, email);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
			modelmap.addAttribute("email", email);
		}
	}

}
