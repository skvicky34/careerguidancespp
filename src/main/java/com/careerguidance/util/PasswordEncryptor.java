package com.careerguidance.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Logger;


import static com.careerguidance.util.ICareerConstants.SALT;

/**
 * This class contains password encryption and decryption methods.
 * @author Amarkant Gupta
 *
 */
public class PasswordEncryptor {
	static final Logger LOGGER = Logger.getLogger(PasswordEncryptor.class.getName());

	/*
	 * This method encrypt a password (or any information) using AES 256 bits.
	 */
	public static String encrypt(String originalPassword, String secretKey) {
		try {
			byte[] initialValues = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(initialValues);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey temp = factory.generateSecret(spec);
			SecretKeySpec secretKeySpec = new SecretKeySpec(temp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(originalPassword.getBytes("UTF-8")));
		} catch (Exception exp) {
			LOGGER.info("Invalid 'password' "+exp.getMessage());
		}
		return null;
	}

	/*
	 * This method decrypt a password (or any information) using AES 256 bits.
	 */
	public static String decrypt(String strToDecrypt, String secretKey) {
		try {
			byte[] initialValues = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(initialValues);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey temp = factory.generateSecret(spec);
			SecretKeySpec secretKeySpec = new SecretKeySpec(temp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception exp) {
			LOGGER.info("Invalid 'email id' or 'password' "+exp.getMessage());
		}
		return null;
	}

	public static String getSecretKey() throws UnknownHostException {
		InetAddress addr;
	    addr = InetAddress.getLocalHost();
	    String hostname = addr.getHostName();
		LOGGER.info("Local Host: "+InetAddress.getLocalHost().toString());
		LOGGER.info("Host: "+hostname);
		return hostname;
	}

}
