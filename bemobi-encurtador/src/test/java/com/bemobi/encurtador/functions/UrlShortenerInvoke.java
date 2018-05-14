package com.bemobi.encurtador.functions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.function.UrlShortenerFunction;
import com.bemobi.encurtador.pojo.UrlResponseInfo;

public class UrlShortenerInvoke {
	private static UrlDTO input;

    @BeforeClass
    public static void createInput() throws IOException {

    	input = new UrlDTO("http://www.infnet.edu.br", "infnet");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here.
        ctx.setFunctionName("UrlShortenerFunction");

        return ctx;
    }

    @Test
    public void testLambdaFormFunctionHandler() {
        UrlShortenerFunction handler = new UrlShortenerFunction();
        Context ctx = createContext();

        UrlResponseInfo output = (UrlResponseInfo) handler.handleRequest(input, ctx);
        output.setStatistics(null);
        
        UrlResponseInfo resultPredicted = new UrlResponseInfo("https://bv4058ifvg.execute-api.us-east-1.amazonaws.com/dev/infnet", "infnet");

        assertEquals(resultPredicted.toString(), output.toString());
    }
}

