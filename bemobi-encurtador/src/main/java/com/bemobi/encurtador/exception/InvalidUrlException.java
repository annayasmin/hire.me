package com.bemobi.encurtador.exception;

/**
 * Class responsible for generating exceptions for invalid urls
 * 
 * Classe <code>InvalidUrlException</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class InvalidUrlException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = 1128563701637411593L;

	/**
	 * Instantiates an exception object with the error message
	 * 
	 * @param message
	 *            error message
	 */
	public InvalidUrlException(final String message) {
		super(message);
	}

}
