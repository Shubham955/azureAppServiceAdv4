package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;

public interface ResetPasswordDao {
	/**
	 * updates password of given user account
	 * @param userAccount
	 * @return
	 */
	int updateUserAccount(UserAccount userAccount);
}
