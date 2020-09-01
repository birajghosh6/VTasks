package com.biraj.springcalls;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service")
public class HomeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path="/allUsers")
	public List<Object> allUsers() {
		
		String url="http://localhost:8080/user/getAllUsers";
		Object[] users=restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(users);
	}
}
