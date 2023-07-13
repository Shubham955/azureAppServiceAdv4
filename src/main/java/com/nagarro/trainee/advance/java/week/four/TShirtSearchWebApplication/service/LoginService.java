package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;

public interface LoginService {
	/**
	 * validates user login 
	 * @param userAccount
	 * @return
	 */
	boolean checkLogin(UserAccount userAccount);
}
