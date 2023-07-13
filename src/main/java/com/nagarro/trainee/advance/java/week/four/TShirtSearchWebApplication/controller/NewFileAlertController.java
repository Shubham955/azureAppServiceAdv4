package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.TShirt;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service.FileCreationAlertService;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Controller
public class NewFileAlertController {

	@Autowired
	FileCreationAlertService fileCreationAlertService;
	
	@RequestMapping("/detectNewFile")
	public String detectNewFileHandler(@RequestParam("tShirtSearchColour") String tShirtColour,
			@RequestParam("tShirtSearchSize") String tShirtSize,
			@RequestParam("tShirtSearchGender") String tShirtGender,
			@RequestParam("outputPreference") String sortOrder,
			Model model) {
//		feeding user sent tShirt search inputs in tShirtSearchDetail
		TShirt tShirtSearchDetail=new TShirt();
		tShirtSearchDetail.setColour(tShirtColour);
		tShirtSearchDetail.setSize(tShirtSize);
		tShirtSearchDetail.setGender(tShirtGender);
		
//		new file creation alert service called
		List<TShirt> recommendedTShirts=fileCreationAlertService.newFileCreated(tShirtSearchDetail, sortOrder);
		
//		checking if new file found
		if(!CollectionUtils.isEmpty(recommendedTShirts))
		model.addAttribute("recommendedTShirts",recommendedTShirts);
		else
		model.addAttribute("noNewFile",TShirtSearchWebApplicationConstants.NO_NEW_FILE_FOUND);
		
		return TShirtSearchWebApplicationConstants.Views.TSHIRT_SEARCH_VIEW;
	}
	
	@ExceptionHandler(value=Exception.class)
	public String errorHandler(Model model)
	{
		model.addAttribute("exceptionOrigin", TShirtSearchWebApplicationConstants.ViewDescriptions.TSHIRT_SEARCH);
		model.addAttribute("redirectUrl", TShirtSearchWebApplicationConstants.RedirectUrl.TSHIRT_SEARCH);
		return TShirtSearchWebApplicationConstants.Views.ERROR_VIEW;
	}
}
