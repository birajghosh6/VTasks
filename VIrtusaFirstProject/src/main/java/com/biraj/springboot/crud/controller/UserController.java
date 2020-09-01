package com.biraj.springboot.crud.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biraj.springboot.crud.entity.User;
import com.biraj.springboot.crud.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserService userService;


	@GetMapping(path="/getAllUsers")
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<>();
		userList.addAll(userService.getAllUsers());
		return userList;
	}

	@GetMapping(path="/getUserById/{userId}")
	public List<User> getUserById(@PathVariable(name="userId") String userId){
		List<User> userList = new ArrayList<>();
		userList.addAll(userService.getUserById(userId));
		return userList;
	}
	
	
	@GetMapping(path="/getAllUsersByIds/{userIds}")
	public List<User> getAllUsersByIds(@PathVariable(name="userIds") String ids){
		List<User> userList=new ArrayList<>();
		userList.addAll(userService.getAllUsersByIds(ids));
		return userList;
	}
	
	
	@PostMapping(path="/saveUser")
	public String saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	
	@PostMapping(path="/saveUserList")
	public String saveUserList(@RequestBody List<User> userList) {
		return userService.saveUserList(userList);
	}
	
	
	@DeleteMapping(path="/deleteUser")
	public String deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}
	
	
	@DeleteMapping(path="/deleteUserById/{userId}")
	public String deleteUserById(@PathVariable(name="userId") String userId) {
		return userService.deleteUserById(userId);
	}
	
	
	@DeleteMapping(path="/deleteAllUserList")
	public String deleteAllUserList(@RequestBody List<User> userList) {
		return userService.deleteAllUserList(userList);
	}
	
	
	@DeleteMapping(path="/deleteAllUsers")
	public String deleteAllUsers() {
		return userService.deleteAllUsers();
	}
	
	
	@DeleteMapping(path="/deleteUsersByIds/{userIds}")
	public String deleteUsersByIds(@PathVariable(name="userIds") List<String> userIds) {
		Iterator<String> itr=userIds.iterator();
		while(itr.hasNext())
			userService.deleteUserById(itr.next());
		return "Deleted Succcessfully";
	}
}
