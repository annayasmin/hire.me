package com.bemobi.encurtador.dto;

/**
 * Url data transfer object.
 * 
 * Class <code>UrlDTO</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class UrlDTO {
	
	/** url */
	private String url;
	
	/** custom alias */
	private String customAlias;

	/**
	 * Get UrlDAO instance
	 */
	public UrlDTO() {
		super();
	}
	
	/**
	 * Get UrlDAO instance
	 * 
	 * @param url
	 * 		url
	 */
	public UrlDTO(String url) {
		super();
		this.url = url;
	}
	
	/**
	 * Get UrlDAO instance
	 * 
	 * @param url
	 * 			url
	 * @param customAlias
	 * 			custom alias
	 */
	public UrlDTO(String url, String customAlias) {
		super();
		this.url = url;
		this.customAlias = customAlias;
	}

	/**
	 * Obtains url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Defines url
	 * 
	 * @param url
	 * 			url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Obtains custom alias
	 * 
	 * @return custom alias
	 */
	public String getCustomAlias() {
		return customAlias;
	}

	/**
	 * Defines custom alias
	 * 
	 * @param customAlias
	 * 			custom alias
	 */
	public void setCustomAlias(String customAlias) {
		this.customAlias = customAlias;
	}

}
