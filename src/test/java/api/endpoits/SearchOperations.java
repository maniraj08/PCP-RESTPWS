package api.endpoits;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.SearchOperationPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SearchOperations {
	
	public static Response cosSearch(SearchOperationPayload payload)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.CosSearch_postUrl);
		return response;
		
	}
	
	public static Response dhcpSearch(SearchOperationPayload payload)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.DhcpSearch_postUrl);
		return response;
		
	}
	
	public static Response fileSearch(SearchOperationPayload payload)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.FileSearch_postUrl);
		return response;
		
	}
	
	public static Response groupSearch(SearchOperationPayload payload)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.GroupSearch_postUrl);
		return response;
		
	}
	
	public static Response SearchDevices(SearchOperationPayload payload)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.SearchDevices_postUrl);
		return response;
		
	}

}
