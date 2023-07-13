package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.impl;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.TShirt;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.FileCreationAlertService;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.service.SuitableTShirtFinderService;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Component
public class FileCreationAlertServiceImpl implements FileCreationAlertService {

	@Autowired
	SuitableTShirtFinderService suitableTShirtFinderService;

	public List<TShirt> newFileCreated(TShirt tShirtSearchDetail, String sortOrder) {
//		variable to store fetched search results
		List<TShirt> recommendedTShirts = null;
		// creation of watch service
		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();

			// creation of path object directed at given directory
			Path path = Paths.get(TShirtSearchWebApplicationConstants.TSHIRT_DIRECTORY);

			// path object registered to be watched for entry creation (file creation)
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			WatchKey key;

			// detects creation of new file for 20 seconds
			while (null != (key = watchService.poll(20, TimeUnit.SECONDS))) {

				// for each file creation event detected following commands executed
				for (WatchEvent<?> event : key.pollEvents()) {

					// for new file created, TShirts searched as per user given inputs
					recommendedTShirts = suitableTShirtFinderService.searchSuitableTShirt(tShirtSearchDetail,
							sortOrder);
				}
				// key reset to detect further changes
				key.reset();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return recommendedTShirts;
	}

}
