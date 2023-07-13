package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service;

import java.util.List;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.TShirt;

public interface SuitableTShirtFinderService {
	/**
	 * searches suitable tshirts as per user given inputs
	 * @param tShirtDetail
	 * @param sortOrder
	 * @return
	 */
	List<TShirt> searchSuitableTShirt(TShirt tShirtDetail, String sortOrder);
}
