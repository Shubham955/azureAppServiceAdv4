package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao.SuitableTShirtFinderDao;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.TShirt;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.SuitableTShirtFinderService;

@Component
public class SuitableTShirtFinderServiceImpl implements SuitableTShirtFinderService {

	@Autowired
	SuitableTShirtFinderDao suitableTShirtFinderDao;
	
	public List<TShirt> searchSuitableTShirt(TShirt tShirtDetail, String sortOrder) {
		// to search t-shirt based on parameters given by user
		List<TShirt> recommendedTShirts= suitableTShirtFinderDao.searchSuitableTShirt(tShirtDetail, sortOrder);
		return recommendedTShirts;
	}
}
