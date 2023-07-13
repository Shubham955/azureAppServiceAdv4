package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.UserAccount;

public interface LoginDao {
	/**
	 * fetches details of given user account
	 * @param userAccount
	 * @return
	 */
	UserAccount readUserAccount(UserAccount userAccount);
}
