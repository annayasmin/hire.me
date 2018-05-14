package com.bemobi.encurtador.functions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.bemobi.encurtador.dto.UrlDTO;
import com.bemobi.encurtador.function.UrlRetrieverFunction;
import com.bemobi.encurtador.pojo.UrlResponseInfo;

public class UrlRetrieverInvoke {
	
	private static UrlDTO input;

    @BeforeClass
    public static void createInput() throws IOException {

    	input = new UrlDTO(null, "infnet");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here.
        ctx.setFunctionName("UrlRetrieverFunction");

        return ctx;
    }

    @Test
    public void testLambdaFormFunctionHandler() {
        UrlRetrieverFunction handler = new UrlRetrieverFunction();
        Context ctx = createContext();

        UrlResponseInfo output = (UrlResponseInfo) handler.handleRequest(input, ctx);

        assertEquals("https://bv4058ifvg.execute-api.us-east-1.amazonaws.com/dev/infnet", output.getLocation());
    }

}
