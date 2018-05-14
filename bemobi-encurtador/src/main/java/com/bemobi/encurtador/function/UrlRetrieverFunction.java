package com.bemobi.encurtador.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.exception.AliasDoesntExistsException;
import com.bemobi.encurtador.facade.UrlFacade;
import com.bemobi.encurtador.facade.UrlFacadeImpl;
import com.bemobi.encurtador.pojo.UrlResponseInfo;
import com.bemobi.encurtador.utils.ErrorConstants;

/**
 * Class that implements a lambda function for an GET on API Gateway.
 * The function is resumed by an url retriever. 
 * It receives an object containing an alias.
 * 
 * Class <code>UrlRetrieverFunction</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 *
 */
public class UrlRetrieverFunction  implements RequestHandler<UrlDTO, UrlResponseInfo>{

	/** url facade */
    private static final UrlFacade urlFacade = new UrlFacadeImpl();

    /*
     * (non-Javadoc)
     * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
     */
	@Override
	public UrlResponseInfo handleRequest(UrlDTO input, Context context) {
		
		UrlResponseInfo response = new UrlResponseInfo();
		
		try {
			response.setLocation(urlFacade.retrieveUrl(input.getCustomAlias()));
			response.setError(ErrorConstants.ERROR_THREE_ZERO_ONE);
			
		} catch (AliasDoesntExistsException e) {
			
			context.getLogger().log("alias not found");
			response.setError(ErrorConstants.ERROR_NOT_FOUND);
		
		}
		
		return response;
	}
    

}
