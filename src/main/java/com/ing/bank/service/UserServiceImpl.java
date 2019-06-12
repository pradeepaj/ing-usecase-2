package com.ing.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.entity.User;
import com.ing.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User insertUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUser(long accountNumber) {

		return userRepository.findByAccountNumber(accountNumber);
	}

}
