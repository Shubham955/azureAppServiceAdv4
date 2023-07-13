package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.ResetPasswordService;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Controller
public class ResetPasswordController {

	@Autowired
	ResetPasswordService resetPasswordService;

	@RequestMapping("/forgotPassword")
	public String forgotPasswordHandler() {
		return TShirtSearchWebApplicationConstants.Views.FORGOT_PASSWORD_VIEW;
	}

	@RequestMapping("/resetPassword")
	public String resetPasswordHandler(@RequestParam("inputUsername") String inputUsername,
			@RequestParam("inputPassword") String inputPassword, Model model) {

//		storing user input username and password into userAccount
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(inputUsername);
		userAccount.setPassword(inputPassword);

		boolean passwordChanged = false;

		// tells returning view's name
		String viewName = null;

		passwordChanged = resetPasswordService.resetPassword(userAccount);

		if (passwordChanged) {
			viewName = TShirtSearchWebApplicationConstants.Views.LOGIN_VIEW;
		} else {
//		attribute set so that user recieves error message
			model.addAttribute("passwordChanged", TShirtSearchWebApplicationConstants.FALSE);
			viewName = TShirtSearchWebApplicationConstants.Views.FORGOT_PASSWORD_VIEW;
		}

		return viewName;
	}

	@ExceptionHandler(value = Exception.class)
	public String errorHandler(Model model) {
		model.addAttribute("exceptionOrigin", TShirtSearchWebApplicationConstants.ViewDescriptions.FORGOT_PASSWORD);
		model.addAttribute("redirectUrl", TShirtSearchWebApplicationConstants.RedirectUrl.FORGOT_PASSWORD);
		return TShirtSearchWebApplicationConstants.Views.ERROR_VIEW;
	}
}
