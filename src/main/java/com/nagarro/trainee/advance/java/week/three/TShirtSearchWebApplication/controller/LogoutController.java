package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logoutHandler() {
		return "LoginTShirtSearchApplication";
	}
}
