package api.endpoits;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.RestRdu;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This is created for perform CURD oprations

public class RestPWSOperationEndpoints {
	
	
	public static Response AddRDU(RestRdu payload,String restun, String restpwd)
	{
		Response response=given()
		
		.relaxedHTTPSValidation()
		.auth().preemptive().basic(restun,restpwd)
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		
		.when()
		.post(MainURL.post_url);
		
		return response;
	}
	
	
	public static Response GetRDU(String restun, String restpwd)
	{
		Response response=given()
				
		.relaxedHTTPSValidation()
		.auth().preemptive().basic(restun,restpwd)
		
		.when()
		.get(MainURL.get_url);
		
		return response;
	}
	
	
	public static Response UpdateRDU(String Rduhostname, RestRdu payload,String restun, String restpwd)
	{
		Response response=given()
		
		.relaxedHTTPSValidation()
		.auth().preemptive().basic(restun,restpwd)
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.pathParam("rduHost", Rduhostname)
		
		.when()
		.put(MainURL.update_url);
		
		return response;
	}
	
	public static Response RemoveRDU(String Rduhostname,String restun, String restpwd)
	{
		Response response=given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic(restun,restpwd)
		.pathParam("rduHost", Rduhostname)
		
		.when()
		.delete(MainURL.delete_url);
		
		return response;
	}

}
