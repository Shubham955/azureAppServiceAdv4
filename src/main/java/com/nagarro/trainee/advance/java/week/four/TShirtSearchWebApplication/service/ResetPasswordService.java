package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;

public interface ResetPasswordService {
	/**
	 * changes user's password
	 * @param userAccount
	 * @return
	 */
	public boolean resetPassword(UserAccount userAccount);
}
