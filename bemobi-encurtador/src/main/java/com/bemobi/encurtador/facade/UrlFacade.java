package com.bemobi.encurtador.facade;

import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.exception.AliasDoesntExistsException;
import com.bemobi.encurtador.exception.AlreadyHasAliasException;
import com.bemobi.encurtador.exception.InvalidUrlException;

/**
 * Interface that defines a service for an Url Object
 * 
 * Interface <code>UrlFacade</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 *
 */
public interface UrlFacade {
	
	/**
	 * retrieve the original url by an alias
	 * 
	 * @param alias
	 * 			alias
	 * 
	 * @return original url
	 * 
	 * @throws AliasDoesntExistsException
	 */
	String retrieveUrl(String alias) throws AliasDoesntExistsException;
	
	/**
	 * save or update a Url object
	 * 
	 * @param url
	 * 			url dto
	 * 
	 * @throws AlreadyHasAliasException
	 * 
	 * @throws InvalidUrlException
	 */
	UrlDTO saveOrUpdateUrl(UrlDTO url) throws AlreadyHasAliasException, InvalidUrlException, AliasDoesntExistsException;

}
