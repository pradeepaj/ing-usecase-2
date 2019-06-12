package com.ing.bank.service;

import com.ing.bank.entity.User;

public interface UserService {

	User insertUser(User user);


	User getUser(long accountNumber);

}
