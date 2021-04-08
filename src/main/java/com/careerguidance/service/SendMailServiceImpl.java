package com.careerguidance.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.careerguidance.model.Otp;
import com.careerguidance.repositories.OtpRepository;
import com.careerguidance.repositories.UserRepository;
import static com.careerguidance.util.ICareerConstants.EMAIL_TO_CC;
import static com.careerguidance.util.ICareerConstants.EMAIL_SUBJECT;
import static com.careerguidance.util.ICareerConstants.EMAIL_TEXT;

/**
 * This service class contains OTP validation and send mail methods logic.
 * @author Amarkant Gupta
 *
 */
@Service
public class SendMailServiceImpl implements SendMailService {

	@Autowired
	OtpRepository otpRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private Environment env;



	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	/*
	 * private static final String SMTP_SERVER = "smtp.gmail.com"; private static
	 * final String USERNAME = ""; // private static final String PASSWORD =
	 * "oldgmail"; private static final String PASSWORD = "Career@12345";
	 * 
	 * private static final String EMAIL_FROM = "careerguidance1991@gmail.com"; //
	 * private static final String EMAIL_FROM = "anirudhabgosavi@gmail.com"; private
	 * static final String EMAIL_TO_CC = "";
	 * 
	 * private static final String EMAIL_SUBJECT = "CAREER GUIDANCE Password Reset";
	 * private static final String EMAIL_TEXT =
	 * " is OTP for CAREER GUIDANCE, Please do not share OTP with " + "anyone.";
	 */

	@Override
	public String generateOtp() throws ClassNotFoundException //create return type string funcion "check()"
	{      
		String otp= new DecimalFormat("0000").format(new Random().nextInt(9999));
		return otp; 
	}

	@Override
	public Otp saveOtp(String email,String otp) {

		Otp otpObj = new Otp();
		otpObj.setEmail(email);
		otpObj.setOtp(otp);

		return otpRepository.save(otpObj);
	}

	@Override
	public Otp updateOtp(Otp otp) {

		return otpRepository.save(otp);
	}


	@Override
	public void sendOtp( String otp,String email) {

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", env.getProperty("spring.mail.host")); //optional, defined in SMTPTransport
		prop.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
		prop.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
		prop.put("mail.smtp.port", env.getProperty("spring.mail.port")); // default port 25

		Session session = Session.getInstance(prop, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));

			}
		});
		Message msg = new MimeMessage(session);

		try {

			msg.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email, false));

			msg.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(EMAIL_TO_CC, false));

			msg.setSubject(EMAIL_SUBJECT);

			msg.setText(otp+" "+EMAIL_TEXT);

			msg.setSentDate(new Date());

			Transport.send(msg);

			System.out.println("Done");

		}catch (MessagingException e) {
			e.printStackTrace();
		}
	}




}
