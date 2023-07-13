package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.UserAccount;

public interface ResetPasswordDao {
	/**
	 * updates password of given user account
	 * @param userAccount
	 * @return
	 */
	int updateUserAccount(UserAccount userAccount);
}
