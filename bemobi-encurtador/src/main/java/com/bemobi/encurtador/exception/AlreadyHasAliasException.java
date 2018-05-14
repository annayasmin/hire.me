package com.bemobi.encurtador.exception;

/**
 * Class responsible for generating exceptions when the alias already exists
 * 
 * Classe <code>AlreadyHasAliasException</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class AlreadyHasAliasException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = 1123879976553187988L;

	/**
	 * Instantiates an exception object with the error message
	 * 
	 * @param message
	 *            error message
	 */
	public AlreadyHasAliasException(final String message) {
		super(message);
	}

}
