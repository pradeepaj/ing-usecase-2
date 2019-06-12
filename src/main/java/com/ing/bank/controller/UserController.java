package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.entity.User;
import com.ing.bank.service.UserService;

@RestController
@RequestMapping("/create")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	@GetMapping("/userDetails/{accountNumber}")
	public User getUserDetails(@PathVariable long accountNumber) {
		return userService.getUser(accountNumber);
	}
	
}
