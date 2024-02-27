package api.endpoits;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import api.payload.COSPayload;
import api.payload.RestRdu;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class COSOperations {

	
	public static  Response CreateSession(RestRdu payload)
	{
		Response response =given()
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.CS_postUrl);
		return response;
	}
	
	public static  Response AddCOS(COSPayload payload)
	{
		 
		 
		Response response =given()
				
		.relaxedHTTPSValidation()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(MainURL.cos_postUrl);
		
		return response;
		
		
	}
	
	public static Response GetCOS(COSPayload payload)
	{
		
		Response response =given()
				
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.cos_getUrl);
				
				return response;
		
	}
	
	public static Response UpdateCOS(COSPayload payload)
	{
		
		Response response =given()
				
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.put(MainURL.cos_updateUrl);
				
				return response;
		
	}
	
	public static Response DeleteCOS(COSPayload payload)
	{
		
		Response response =given()
				
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.delete(MainURL.cos_deleteUrl);
				
				return response;
		
	}
}


