package com.lovemesomecoding.utils;

import javax.management.RuntimeErrorException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author fkaveinga
 *
 */
public final class PasswordUtils {

	private static final int TEMP_PASSWORD_LENGTH = 10;
	final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private PasswordUtils() {
	}

	/*
	 * Password for development only
	 */
	public static String hashPassword(final String password) {
		return passwordEncoder.encode(password);
	}

	public static boolean verify(String password, String hashPassword) {
		return passwordEncoder.matches(password, hashPassword);
	}

}
