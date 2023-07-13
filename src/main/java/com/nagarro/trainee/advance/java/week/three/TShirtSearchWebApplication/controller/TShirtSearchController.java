package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.TShirt;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.SuitableTShirtFinderService;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Controller
public class TShirtSearchController {
	
	@Autowired
	SuitableTShirtFinderService suitableTShirtFinderService;
	
	@RequestMapping("/tShirtSearchApplication")
	public String tShirtSearchApplicationHandler()
	{
		return TShirtSearchWebApplicationConstants.Views.TSHIRT_SEARCH_VIEW;
	}
	
	@RequestMapping(path="/searchTShirt", method=RequestMethod.POST)
	public String searchTShirtHandler(@RequestParam("tShirtColour") String tShirtColour, 
			@RequestParam("tShirtSize") String tShirtSize,
			@RequestParam("tShirtGender") String tShirtGender,
			@RequestParam("outputPreference") String sortOrder,
			Model model) {
//		feeding input search details by user into tShirtSearchDetail
		TShirt tShirtSearchDetail=new TShirt();
		tShirtSearchDetail.setColour(tShirtColour);
		tShirtSearchDetail.setSize(tShirtSize);
		tShirtSearchDetail.setGender(tShirtGender);
		
//		storing fetched results in recommendedTShirts
		List<TShirt> recommendedTShirts=suitableTShirtFinderService.searchSuitableTShirt(tShirtSearchDetail, sortOrder);
		
//		checking if no results fetched
		if(!CollectionUtils.isEmpty(recommendedTShirts))
		{
			//attribute set for displaying results
			model.addAttribute("recommendedTShirts",recommendedTShirts);
//			following attributes set to transfer user given search input to file alert process
			model.addAttribute("tShirtColour",tShirtColour);
			model.addAttribute("tShirtSize",tShirtSize);
			model.addAttribute("tShirtGender",tShirtGender);
			model.addAttribute("outputPreference",sortOrder);
		}
		else
		{
//			if no result found
			model.addAttribute("noResult",TShirtSearchWebApplicationConstants.RESULT_NOT_FOUND);
		}
		
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

