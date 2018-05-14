package com.bemobi.encurtador.pojo;

/**
 * Simple POJO class for lambda functions response informations
 * 
 * Class <code>Statistics</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class Statistics {
	
	/** time taken */
	private String timeTaken;

	/**
	 * Instantiates a new Statistics object
	 */
	public Statistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Statistics object
	 * 
	 * @param timeTaken
	 * 			time taken
	 */
	public Statistics(String timeTaken) {
		super();
		this.timeTaken = timeTaken;
	}

	/**
	 * Obtains time taken
	 * 
	 * @return time taken
	 */
	public String getTimeTaken() {
		return timeTaken;
	}

	/**
	 * Defines time taken
	 * 
	 * @param timeTaken
	 * 			time taken
	 */
	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

}
