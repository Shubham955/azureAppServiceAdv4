package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.service;

import java.util.List;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.TShirt;

public interface FileCreationAlertService {
	/**
	 * detects creation of new file
	 * @param tShirtSearchDetail
	 * @param sortOrder
	 * @return
	 */
	List<TShirt> newFileCreated(TShirt tShirtSearchDetail, String sortOrder);
}
