package com.bemobi.encurtador.pojo;

/**
 * Simple POJO class for lambda functions response informations
 * 
 * Class <code>UrlResponseInfo</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class UrlResponseInfo {
	
	/** url */
	private String url;
	
	/** alias */
	private String alias;
	
	/** error */
	private String error;
	
	/** description */
	private String description;
	
	/** location */
	private String location;
	
	/** statistics */
	private Statistics statistics;

	/**
	 * Instantiates an UrlResponseInfo object
	 */
	public UrlResponseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates an UrlResponseInfo object
	 * 
	 * @param url
	 * 			url
	 * @param alias
	 * 			alias
	 * @param statistics
	 * 			statistics
	 */
	public UrlResponseInfo(String url, String alias, Statistics statistics) {
		super();
		this.url = url;
		this.alias = alias;
		this.statistics = statistics;
	}

	/**
	 * Instantiates an UrlResponseInfo object
	 * 
	 * @param alias
	 * 			alias
	 * @param error
	 * 			error
	 * @param description
	 * 			description
	 */
	public UrlResponseInfo(String alias, String error, String description) {
		super();
		this.alias = alias;
		this.error = error;
		this.description = description;
	}

	/**
	 * Instantiates an UrlResponseInfo object
	 * 
	 * @param error
	 * 			error
	 * @param description
	 * 			description
	 */
	public UrlResponseInfo(String error, String description) {
		super();
		this.error = error;
		this.description = description;
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
	 * Obtains alias
	 * 
	 * @return alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Defines alias
	 * 
	 * @param alias
	 * 			alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Obtains error code
	 * 
	 * @return error code
	 */
	public String getError() {
		return error;
	}

	/**
	 * Defines error code
	 * 
	 * @param error
	 * 			error code
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Obtains error description
	 * 
	 * @return error description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Defines error description
	 * 
	 * @param description
	 * 			error description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Obtains a location 
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Defines a location
	 * 
	 * @param location
	 * 			location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Obtains statistics
	 * 
	 * @return statistics
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * Defines statistics
	 * 
	 * @param statistics
	 * 			statistics
	 */
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

}
