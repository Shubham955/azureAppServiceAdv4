package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao;

import java.util.List;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.TShirt;

public interface SuitableTShirtFinderDao {
	/**
	 * fetches suitable tShirts as per user given inputs
	 * @param tShirtDetail
	 * @param sortOrder
	 * @return
	 */
	List<TShirt> searchSuitableTShirt(TShirt tShirtDetail, String sortOrder);
}
