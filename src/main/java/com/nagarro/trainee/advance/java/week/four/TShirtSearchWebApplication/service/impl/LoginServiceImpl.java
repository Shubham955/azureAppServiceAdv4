package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.LoginDao;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	public boolean checkLogin(UserAccount userAccount) {
//		variable to store fetched password from database
		String storedPassword = null;
//		user given password stored
		String inputPassword = userAccount.getPassword();
		
		UserAccount storedUserAccount = loginDao.readUserAccount(userAccount);
		
		// if user exists then password fetched
		if (Objects.nonNull(storedUserAccount)) {
			storedPassword = storedUserAccount.getPassword();
		}

		boolean userVerified = false;
		// if input password matches with fetched password
		if (inputPassword.equals(storedPassword)) {
			userVerified = true;
		}

		return userVerified;
	}
}
