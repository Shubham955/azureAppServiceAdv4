package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//class to be treated as entity
@Entity
//table name of TShirt entity to be TShirtInventory
@Table(name="TShirtInventory")
public class TShirt{
	//id treated as primary key
	@Id
	private String id;
	private String name;
	private String colour, gender, size;

	private float price, rating;
	private String availability;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format("%20s%32s%10s%10s%7s\t%.2f\t%.2f", id, name, colour, gender, size, price, rating);
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}


