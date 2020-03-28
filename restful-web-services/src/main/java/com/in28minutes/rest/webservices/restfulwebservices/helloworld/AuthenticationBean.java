package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

// Beans usually have getters and setters. Also have no arg constructors ..(?) Though maybe not the case with Spring Beans
// Spring Beans are handled by Spring, kind of like regular Beans or can be PoJos

public class AuthenticationBean {
	
	private String message;
	
	public AuthenticationBean(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
