package net.gjerull.etherpad.client;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;

@RunWith(JUnitQuickcheck.class)
public class EPLiteConnectionPropertiesTest {
    
	private static final String API_VERSION = "1.2.12";
    private static final String ENCODING = "UTF-8";
    private static final String RESPONSE_TEMPLATE = "{\n" + "  \"code\": %d,\n" + "  \"message\": \"%s\",\n" + "  \"data\": %s\n" + "}";

    @Before
    public void setUp() {
        ((ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory
         .getLogger("junit-quickcheck.value-reporting"))
            .setLevel(ch.qos.logback.classic.Level.OFF);
    }
    
    @Property
    public void domain_with_slash_when_constructing_api_path(String exampleMethod) throws Exception {

        EPLiteConnection connection = new EPLiteConnection("http://example.com/", "apikey", API_VERSION, ENCODING);
        
        String apiMethodPath = connection.apiPath(exampleMethod);
        
        assertEquals("/api/1.2.12/" + exampleMethod, apiMethodPath);
    }
    
	@Property(trials = 25)
	public void query_string_from_map(int rev, String apikey, String padId) throws Exception {
		
		EPLiteConnection connection = new EPLiteConnection("http://example.com/", apikey, API_VERSION, ENCODING);
		
		Map<String, Object> args = new TreeMap<>();
		
		args.put("padID", padId);
		args.put("rev", rev);

		String queryString = connection.queryString(args, false);

		assertEquals("apikey=" + apikey + "&padID=" + padId + "&rev=" + rev, queryString);
	}

	@Property(trials = 25)
	public void domain_without_slash_when_constructing_api_path(String method) throws Exception {
		
		EPLiteConnection connection = new EPLiteConnection("http://example.com", "apikey", API_VERSION, ENCODING);
		
		String apiMethodPath = connection.apiPath(method);
		
		assertEquals("/api/1.2.12/" + method, apiMethodPath);
	}
	
	@Property(trials = 25)
	public void api_url_need_to_be_absolute(String apikey, String path) throws Exception {
		
		try {
			
			EPLiteConnection connection = new EPLiteConnection("http://example.com/", apikey, API_VERSION, ENCODING);
			
			connection.apiUrl(path, null);
			
			if (path.length() > 0) {
				
				fail("Expected '" + EPLiteException.class.getName() + "' to be thrown");
				
			}
			
		} catch (EPLiteException e) {
			
			assertTrue(true);
			
		}
	}

	@Property(trials = 25)
	public void handle_error_invalid_parameter_from_server(@InRange(min = "1") int code, String apikey, String response) throws Exception {
		
		EPLiteConnection connection = new EPLiteConnection("http://example.com/", apikey, API_VERSION, ENCODING);
		
		String serverResponse = String.format(RESPONSE_TEMPLATE, code, response, null);

		try {
			
			connection.handleResponse(serverResponse);
			
			fail("Expected '" + EPLiteException.class.getName() + "' to be thrown");
			
		} catch (EPLiteException e) {
			
			if (code > 4) {
				
				assertEquals("An unknown error has occurred while handling the response: " + serverResponse, e.getMessage());
				
			} else {
				
				assertEquals(response, e.getMessage());
				
			}
		}

	}
	
	
}
