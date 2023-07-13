package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//class to be treated as entity
@Entity
//table name of UserAccount to be loginaccount
@Table(name="loginaccount")
public class UserAccount {
	@Id
	private String username;
	private String password;
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
}

