package com.nagarro.trainee.advance.java.week.three.TShirtSearchWebApplication.util;

public class TShirtSearchWebApplicationConstants {
	public static final String FALSE = "false";
	public static final String TSHIRT_DIRECTORY = "";

	public interface OutputPreference {
		public static final String PRICE = "price";
		public static final String RATING = "rating";
		public static final String BOTH = "both";
	}

	public static final String RESULT_NOT_FOUND = "Result not found";
	public static final String NO_NEW_FILE_FOUND = "No new file found";
	
	public interface Views{
		public static final String FORGOT_PASSWORD_VIEW="ForgotPassword";
		public static final String ERROR_VIEW="ErrorPageTShirtSearchApplication";
		public static final String LOGIN_VIEW="LoginTShirtSearchApplication";
		public static final String TSHIRT_SEARCH_VIEW="TShirtSearch";
	}
	
	public interface RedirectUrl{
		public static final String LOGIN_PAGE="loginPage";
		public static final String TSHIRT_SEARCH="tShirtSearchApplication";
		public static final String FORGOT_PASSWORD="forgotPassword";
	}
	
	public interface ViewDescriptions{
		public static final String LOGIN_PAGE="Login Page";
		public static final String TSHIRT_SEARCH="TShirt Search Application";
		public static final String FORGOT_PASSWORD="Forgot Password Page";
	}
}
