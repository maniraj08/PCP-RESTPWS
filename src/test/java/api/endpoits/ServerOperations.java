package api.endpoits;

import static io.restassured.RestAssured.given;

import api.payload.RestRdu;
import api.payload.ServerOperationsPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServerOperations {
	
	
	public static Response getAllCNRs(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.Allcnr_postUrl);
				return response;
	}
	
	public static Response getAllDPEs(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.Alldpe_postUrl);
				return response;
	}
	
	public static Response getAllProvGrps(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.AllprovGp_postUrl);
				return response;
	}
	
	public static Response getCNRDetails(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.getCnr_postUrl);
				return response;
	}
	
	public static Response getDefaults(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.getDefaults_postUrl);
				return response;
	}
	
	public static Response getDPEDefaults(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.getDPEDefaults_postUrl);
				return response;
	}

	public static Response getDPEDetails(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.getdpe_postUrl);
				return response;
	}
	
	public static Response getExtensionPointSettings(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MainURL.getExtensionPointSettings_postUrl);
				return response;
	}
	
	public static Response changeDefaults(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.put(MainURL.changeDefaults_putUrl);
				return response;
	}
	
	public static Response changeRDUDefaults(ServerOperationsPayload payload)
	{
		Response response =given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.put(MainURL.changeRDUDefaults_putUrl);
				return response;
	}
}
