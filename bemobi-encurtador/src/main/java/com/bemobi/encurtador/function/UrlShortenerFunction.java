package com.bemobi.encurtador.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.exception.AliasDoesntExistsException;
import com.bemobi.encurtador.exception.AlreadyHasAliasException;
import com.bemobi.encurtador.exception.InvalidUrlException;
import com.bemobi.encurtador.facade.UrlFacade;
import com.bemobi.encurtador.facade.UrlFacadeImpl;
import com.bemobi.encurtador.pojo.Statistics;
import com.bemobi.encurtador.pojo.UrlResponseInfo;
import com.bemobi.encurtador.utils.ErrorConstants;
import com.bemobi.encurtador.utils.ShortenerUtils;

/**
 * Class that implements a lambda function for an PUT on API Gateway.
 * The function is resumed by an url shortener. 
 * It receives an object containing url and on optional custom alias.
 * 
 * Class <code>UrlShortenerFunction</code>
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 *
 */
public class UrlShortenerFunction implements RequestHandler<UrlDTO, Object>{

	/** url facade */
    private static final UrlFacade urlFacade = new UrlFacadeImpl();
    
    /*
     * (non-Javadoc)
     * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
     */
    @Override
    public Object handleRequest(UrlDTO input, Context context) {
		long tempoInicial = System.currentTimeMillis();
		UrlResponseInfo response = null;
		
		if(input.getCustomAlias() == null || input.getCustomAlias().isEmpty() ) {
			input.setCustomAlias(ShortenerUtils.generateKey());
		}
        
        try {
        	UrlDTO responseDTO = urlFacade.saveOrUpdateUrl(input);
			context.getLogger().log("Successfully saved url");
			
			String shortenedUrl = ShortenerUtils.generateShortUrl(input.getCustomAlias());
	        
	        String tempoOperacao = String.valueOf(System.currentTimeMillis() - tempoInicial) + "ms";
	        Statistics statistics = new Statistics(tempoOperacao);
	        
	        response = new UrlResponseInfo(shortenedUrl, responseDTO.getCustomAlias(), statistics);
			
		} catch (AlreadyHasAliasException e) {
			context.getLogger().log("SaveUrl received an used alias");
			response = new UrlResponseInfo(input.getCustomAlias(), ErrorConstants.ERROR_ONE, ErrorConstants.ERROR_ONE_MESSAGE);
		
		} catch (InvalidUrlException e) {
			context.getLogger().log("SaveUrl received invalid url");
			response = new UrlResponseInfo(ErrorConstants.ERROR_TWO, ErrorConstants.ERROR_TWO_MESSAGE);
			
		} catch (AliasDoesntExistsException e) {
			context.getLogger().log("the system wasn't able to save item");
			response = new UrlResponseInfo(ErrorConstants.ERROR_THREE, ErrorConstants.ERROR_THREE_MESSAGE);
		}
        
        return response;
	}
}
