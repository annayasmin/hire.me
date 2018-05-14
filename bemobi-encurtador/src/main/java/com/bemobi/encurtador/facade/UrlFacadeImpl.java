package com.bemobi.encurtador.facade;

import com.bemobi.encurtador.dao.UrlDAO;
import com.bemobi.encurtador.domain.Url;
import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.exception.AliasDoesntExistsException;
import com.bemobi.encurtador.exception.AlreadyHasAliasException;
import com.bemobi.encurtador.exception.InvalidUrlException;
import com.bemobi.encurtador.utils.ErrorConstants;
import com.bemobi.encurtador.utils.ShortenerUtils;

/**
 * Classe that implements the services for UrlFacade interface
 * 
 * Class <code>UrlFacadeImpl</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 *
 */
public class UrlFacadeImpl implements UrlFacade {
	
	/** url dao */
	private static final UrlDAO urlDAO = UrlDAO.instance();

	/**
	 * checks if there is an alias
	 * 
	 * @param alias
	 * 			alias
	 * 
	 * @return boolean
	 */
	private boolean doesAliasExists(String alias) {
		
		Url urlResult = urlDAO.findUrlByAlias(alias);
		
		if(urlResult != null) {
			return true;
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bemobi.encurtador.facade.UrlFacade#retrieveUrl(java.lang.String)
	 */
	@Override
	public String retrieveUrl(String alias) throws AliasDoesntExistsException {
		
		if(alias == null) {
			throw new AliasDoesntExistsException(ErrorConstants.ERROR_NOT_FOUND);
		}
		
		Url urlResult = urlDAO.findUrlByAlias(alias);
		
		return urlResult.getUrl();
	}

	/*
	 * (non-Javadoc)
	 * @see com.bemobi.encurtador.facade.UrlFacade#saveOrUpdateUrl(com.bemobi.encurtador.dto.UrlDTO)
	 */
	@Override
	public UrlDTO saveOrUpdateUrl(UrlDTO urlInput) throws AlreadyHasAliasException, InvalidUrlException, AliasDoesntExistsException {
		
		if (this.doesAliasExists(urlInput.getCustomAlias())) {
			throw new AlreadyHasAliasException(ErrorConstants.ERROR_ONE_MESSAGE);
		}
		
		if (!ShortenerUtils.validUrl(urlInput.getUrl())) {
			throw new InvalidUrlException(ErrorConstants.ERROR_TWO_MESSAGE);
        }
		
		Url urlToBeSaved = new Url(urlInput.getUrl(), urlInput.getCustomAlias());
		
		Url savedUrl = urlDAO.saveOrUpdateUrl(urlToBeSaved);
		UrlDTO savedUrlDTO = new UrlDTO(savedUrl.getUrl(), savedUrl.getAlias());
		
		return savedUrlDTO;
	}

}
