package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.ResetPasswordDao;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.ResetPasswordService;

@Component
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	ResetPasswordDao resetPasswordDao;

	public boolean resetPassword(UserAccount userAccount) {
		// tells whether password changed
		boolean passwordChanged = false;
		int recordsUpdated = resetPasswordDao.updateUserAccount(userAccount);

// if 1 record updated then password changed else not changed
		if (1 == recordsUpdated)
			passwordChanged = true;

		return passwordChanged;
	}
}
