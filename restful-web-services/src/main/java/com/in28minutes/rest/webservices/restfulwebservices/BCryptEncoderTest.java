package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// Just for test creating a new user, loop 10 times, create an ecncrypted password
		for (int i=0; i<10; i++) {
			String encodedString = encoder.encode("password@123@#!");
			System.out.println(encodedString);
		}

	}

}
