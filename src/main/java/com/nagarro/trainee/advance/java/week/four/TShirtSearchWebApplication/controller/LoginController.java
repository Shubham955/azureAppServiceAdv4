package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.LoginService;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping("/loginPage")
	public String loginHandler() {
		return TShirtSearchWebApplicationConstants.Views.LOGIN_VIEW;
	}

	@RequestMapping("/")
	public String home() {
		return TShirtSearchWebApplicationConstants.Views.LOGIN_VIEW;
	}

	@RequestMapping(path = "/loginCheck", method = RequestMethod.POST)
	public String validatingLoginHandler(@RequestParam("inputUsername") String inputUsername,
			@RequestParam("inputPassword") String inputPassword, Model model) {
//	storing user given input into userAccount
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(inputUsername);
		userAccount.setPassword(inputPassword);
		
		boolean userVerified = loginService.checkLogin(userAccount);
		
		//tells which view to return
		String viewName=null;
		
		// if correct credentials entered
		if (userVerified) {
			//attribute set so that username displayed on tShirt search page
			model.addAttribute("signedInUser", userAccount.getUsername());
			
			viewName=TShirtSearchWebApplicationConstants.Views.TSHIRT_SEARCH_VIEW;
		}
		else {
			// if incorrect credentials entered
			model.addAttribute("userVerified", TShirtSearchWebApplicationConstants.FALSE);
			viewName=TShirtSearchWebApplicationConstants.Views.LOGIN_VIEW;
		}
		return viewName;
	}

	@ExceptionHandler(value = Exception.class)
	public String errorHandler(Model model) {
		model.addAttribute("exceptionOrigin", TShirtSearchWebApplicationConstants.ViewDescriptions.LOGIN_PAGE);
		model.addAttribute("redirectUrl", TShirtSearchWebApplicationConstants.RedirectUrl.LOGIN_PAGE);
		return TShirtSearchWebApplicationConstants.Views.ERROR_VIEW;
	}

}
