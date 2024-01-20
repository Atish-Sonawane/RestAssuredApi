package RestApi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {
	
	void getweatherDetails() {
		
		// Specify base URI
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET, "/Hyderabad");
		
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("response body is :"+ responseBody);
		
		//status code validation
		int statusCode= response.getStatusCode();
		System.out.println("statusCode is : "+ statusCode);
		Assert.assertEquals(200, statusCode);
		
		//status line validation
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is: "+statusLine);
		Assert.assertEquals("HTTP/1.1 200 ok", statusLine);
		
	}

}
