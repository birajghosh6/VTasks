package com.biraj.springboot.crud.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biraj.springboot.crud.entity.User;
import com.biraj.springboot.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Collection<? extends User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}
	public Collection<? extends User> getUserById(String userId) {
		List<User> userList = new ArrayList<>();
		userList.add(userRepository.findById(userId).get());
		return userList;
	}
	public Collection<? extends User> getAllUsersByIds(String ids) {
		List<User> userList = new ArrayList<>();
		List<String> idList = Arrays.asList(ids.split(","));
		userRepository.findAllById(idList).forEach(userList::add);;
		return userList;
	}
	public String saveUser(User user) {
		User savedUser = userRepository.save(user);
		if(savedUser!=null)
			return "Saved : userId - "+savedUser.getUserId();
		else
			return "Failed : userId - "+user.getUserId();
	}
	public String saveUserList(List<User> userList) {
		List<User> savedUserList = new ArrayList<>();
		userRepository.saveAll(userList).forEach(savedUserList::add);
		return "Saved : user ids -"+savedUserList.stream().map(u->u.getUserId()).collect(Collectors.toList());
	}
	public String deleteUser(User user) {
		userRepository.delete(user);
		return "Delete Successfully";
	}
	public String deleteUserById(String userId) {
		try
		{
			userRepository.deleteById(userId);
			return "Deleted Successfully";
		}
		catch(Exception e)
		{
			return "User with userId-"+userId+" does not exist";
		}
	}
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "Deleted Successfully";
	}
	public String deleteAllUserList(List<User> userList) {
		userRepository.deleteAll(userList);
		return "Deleted Successfully";
	}
	
}
