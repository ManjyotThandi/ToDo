package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Define that this is a controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	@GetMapping(path="/basicauth")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public AuthenticationBean getWelcomeMessage(@PathVariable String name) {
		return new AuthenticationBean("Welcome" + name);
	}
	
	// This is the bean URI for hello-world
	@GetMapping(path="/hello-world-bean")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are Authenticated");
	}
}
	