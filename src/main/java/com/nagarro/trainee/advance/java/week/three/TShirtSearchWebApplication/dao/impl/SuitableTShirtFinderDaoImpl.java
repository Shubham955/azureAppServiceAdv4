package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.dao.SuitableTShirtFinderDao;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model.TShirt;
import com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.util.TShirtSearchWebApplicationConstants;

@Component
public class SuitableTShirtFinderDaoImpl implements SuitableTShirtFinderDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	void createTShirtInventory() {
		// listing files in given directory
		File[] filesList = new File(TShirtSearchWebApplicationConstants.TSHIRT_DIRECTORY).listFiles();

		// traversing each file and inserting TShirt details in database
		for (File fileName : filesList) {
			try {
				// created buffered reader to read current file
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

				// stores current line of file being traversed
				String fileLine;

//				session created
				Session session = this.hibernateTemplate.getSessionFactory().openSession();

				// session begins
				session.beginTransaction();

				// for empty file and for skipping first line containing headers
				if (null != bufferedReader.readLine()) {
					// while file has some line while loop keeps on reading
					while (null != (fileLine = bufferedReader.readLine())) {
						// TShirt object created to store details of TShirt as specified in current line
						TShirt tShirt = new TShirt();

						// tells column index if current line broken into columns based on delimiter
						int columnIndex = 1;

						// stores index of delimiter
						int delimiterIndex;

						// breaks fileLine string based on delimiter
						while (-1 != (delimiterIndex = fileLine.indexOf("|"))) {
							// column data at ongoing column index
							String columnData = fileLine.substring(0, delimiterIndex);
							// making new substring removing extracted column data
							fileLine = fileLine.substring(delimiterIndex + 1, fileLine.length());

							// based on column index setting values of TShirt parameters
							switch (columnIndex) {
							case 1:
								tShirt.setId(columnData);
								break;
							case 2:
								tShirt.setName(columnData);
								break;
							case 3:
								tShirt.setColour(columnData);
								break;
							case 4:
								tShirt.setGender(columnData);
								break;
							case 5:
								tShirt.setSize(columnData);
								break;
							case 6:
								tShirt.setPrice(Float.parseFloat(columnData));
								break;
							case 7:
								tShirt.setRating(Float.parseFloat(columnData));
								break;
							}

							// after every loop column index incremented as after each delimiter value of
							// next column written in fileLine
							columnIndex++;
						}
						// after last delimiter in fileLine value of availability column left
						tShirt.setAvailability(fileLine);

						// saves TShirt object
						session.save(tShirt);
					}
					// transaction commited
					session.getTransaction().commit();

					// session closed
					session.close();
				}
				// bufferedReader closed
				bufferedReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<TShirt> searchSuitableTShirt(TShirt tShirtDetail, String sortOrder) {
		// call to create inventory function to insert TShirts as in given files
		createTShirtInventory();

		// deciding order by terms as per given sort order (output preference) by user
		String orderTerm1 = "", orderTerm2 = "";
		if (TShirtSearchWebApplicationConstants.OutputPreference.PRICE.equals(sortOrder.toLowerCase())) {
			orderTerm1 = orderTerm2 = sortOrder;
		} else if (TShirtSearchWebApplicationConstants.OutputPreference.RATING.equals(sortOrder.toLowerCase())) {
			orderTerm1 = orderTerm2 = sortOrder;
		} else if (TShirtSearchWebApplicationConstants.OutputPreference.BOTH.equals(sortOrder.toLowerCase())) {
			orderTerm1 = "price";
			orderTerm2 = "rating";
		}

//		session created
		Session session = this.hibernateTemplate.getSessionFactory().openSession();

//		transaction begins
		session.beginTransaction();

		String sqlQueryString = "SELECT * from `product2`.`tshirtinventory` where availability='Y' AND colour='"
				+ tShirtDetail.getColour() + "' AND gender='" + tShirtDetail.getGender() + "' AND size='"
				+ tShirtDetail.getSize() + "' order by " + orderTerm1 + "," + orderTerm2;

		// list to store recommended TShirts
		List<TShirt> recommendedTShirts = session.createNativeQuery(sqlQueryString, TShirt.class).list();

		// transaction commited
		session.getTransaction().commit();

//		session closed
		session.close();

//		inventory truncated so that when another search done by user primary key exception doesn't comes on create inventory call
		truncateTShirtInventory();

		return recommendedTShirts;
	}

	void truncateTShirtInventory() {
//session created
		Session session = this.hibernateTemplate.getSessionFactory().openSession();

		// transaction begins
		session.beginTransaction();

		String sqlQueryString = "Truncate tshirtinventory";

		session.createNativeQuery(sqlQueryString).executeUpdate();

//		transaction commited
		session.getTransaction().commit();
		
//		session closed
		session.close();
	}
}
