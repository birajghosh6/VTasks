package com.biraj.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping("/")
	public String home() {
		return("<h1>This is the homepage</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return("<h1>This is the administrator page</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return("<h1>This is the user page</h1>");
	}
	
}
