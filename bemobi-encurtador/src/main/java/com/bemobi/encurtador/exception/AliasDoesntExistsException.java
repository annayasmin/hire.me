package com.bemobi.encurtador.exception;

/**
 * Class responsible for generating exceptions when the alias doesn't exists
 * 
 * Classe <code>AliasDoesntExistsException</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class AliasDoesntExistsException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = 2584844838729956491L;
	
	/**
	 * Instantiates an exception object with the error message
	 * 
	 * @param message
	 *            error message
	 */
	public AliasDoesntExistsException(final String message) {
		super(message);
	}

}
