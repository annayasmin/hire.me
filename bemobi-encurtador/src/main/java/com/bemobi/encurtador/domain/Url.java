package com.bemobi.encurtador.domain;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * This class represents all informations about a shortened url.
 * 
 * Class <code>Url</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
@DynamoDBTable(tableName = "Urls" )
public class Url implements Serializable {
	
	/** serialVersionUID */
	@DynamoDBIgnore
	private static final long serialVersionUID = 1284985649365903798L;

	/** url */
	@DynamoDBAttribute(attributeName="url")
	private String url;
	
	/** alias */
	@DynamoDBHashKey(attributeName="alias")
	private String alias;
	
	/** access number */
	@DynamoDBAttribute(attributeName="accessNumber")
	private Integer accessNumber;

	/**
	 * Instantiates an Url Object
	 */
	public Url() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates an Url Object
	 * 
	 * @param url
	 * 			url
	 * @param alias
	 * 			alias
	 */
	public Url(String url, String alias) {
		super();
		this.url = url;
		this.alias = alias;
	}
	
	/**
	 * Instantiates an Url Object
	 * 
	 * @param url
	 * 			url
	 * @param alias
	 * 			alias
	 * @param accessNumber
	 * 			access number
	 */
	public Url(String url, String alias, Integer accessNumber) {
		super();
		this.url = url;
		this.alias = alias;
		this.accessNumber = accessNumber;
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
	 * Obtains access number
	 * 
	 * @return access number
	 */
	public Integer getAccessNumber() {
		return accessNumber;
	}

	/**
	 * Defines access number
	 * 
	 * @param accessNumber
	 * 			access number
	 */
	public void setAccessNumber(Integer accessNumber) {
		this.accessNumber = accessNumber;
	}
	
}
