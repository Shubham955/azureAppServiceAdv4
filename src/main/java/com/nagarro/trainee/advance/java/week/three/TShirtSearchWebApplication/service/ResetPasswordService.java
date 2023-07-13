package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.UserAccount;

public interface ResetPasswordService {
	/**
	 * changes user's password
	 * @param userAccount
	 * @return
	 */
	public boolean resetPassword(UserAccount userAccount);
}
