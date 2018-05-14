package com.bemobi.encurtador.utils;

import java.util.Random;

import org.apache.commons.validator.routines.UrlValidator;

/**
 * Url data transfer object.
 * 
 * Class <code>UrlDTO</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class ShortenerUtils {
	
	/** base url */
	private static final String BASE_URL_SHORT = "https://bv4058ifvg.execute-api.us-east-1.amazonaws.com/dev/";

	/**
	 * method the generates a full shortened url by an alias
	 * 
	 * @param alias
	 * 			alias
	 * @return full shortened url
	 */
	public static String generateShortUrl(String alias) {
		
		return BASE_URL_SHORT + alias;
	}
	
	/**
	 * generates an alias
	 * 
	 * @return alias
	 */
	public static String generateKey(){
		return generateKey(7,"ABCDEFGHIJKLMNPQRSTUVXZWYabcdefghijkmnpqrstuvxzwy23456789");
	}	
	
	/**
	 * genrates an alias by a length and characters
	 * 
	 * @param length
	 * 			length
	 * 
	 * @param characters
	 * 			characters
	 * 
	 * @return alias
	 */
	private static String generateKey(int length, String characters) {
		Random random = new Random();
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < length; i++) {
			output.append(characters.charAt(random.nextInt(characters.length())));
		}
		return output.toString();
		
	}
	
	/**
	 * checks if the url is valid or not
	 * 
	 * @param urlValue
	 * 			url value
	 * 
	 * @return boolean
	 */
	public static boolean validUrl(String urlValue) {

		UrlValidator urlValidator = new UrlValidator();
		
		if (urlValidator.isValid(urlValue)) {
			return true;
			
		} else {
		   return false;
		}
	}

}
