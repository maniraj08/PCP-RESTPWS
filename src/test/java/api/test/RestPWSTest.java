package api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoits.RestPWSOperationEndpoints;
import api.payload.RestRdu;

import io.restassured.response.Response;

public class RestPWSTest {
	
	RestRdu rdupayload;
	
	public Logger logger;
	
	@BeforeClass()
	public void InputData()
	{
		
		rdupayload=new RestRdu();
		rdupayload.setRduHost("pcp-lnx-92");
		rdupayload.setUsername("admin");
		rdupayload.setPassword("admin123");
		rdupayload.setRduPort("49188");
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void testAddRdu()
	{
		logger.info("******Adding RDU***********");
		Response response=RestPWSOperationEndpoints.AddRDU(rdupayload,"test","test123");
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		logger.info("******RDU Added ***********");
	}
	@Test(priority=2)
	public void testGetRdu()
	{
		logger.info("******Get RDU***********");
		Response response=RestPWSOperationEndpoints.GetRDU("test","test123");

		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
    @Test(priority=3)
	public void testUpdateRdu()
	{
    	logger.info("******Update RDU***********");
    	rdupayload.setUsername("admin1");
    	
    	//this keyword will refer the current variable
		Response response=RestPWSOperationEndpoints.UpdateRDU(this.rdupayload.getRduHost(), rdupayload,"test","test123");

		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
		//responseafterUpdate
		
		Response Afterupdateresponse=RestPWSOperationEndpoints.GetRDU("test","test123");

		Afterupdateresponse.then().log().all();
		
		Assert.assertEquals(Afterupdateresponse.getStatusCode(), 200);
		
		logger.info("******Updated RDU Details***********");
		
	}
    @Test(priority=4)
	public void testDeleteRdu()
	{
    	logger.info("******Delete RDU***********");
		Response response=RestPWSOperationEndpoints.RemoveRDU(this.rdupayload.getRduHost(),"test","test123");

		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
		logger.info("******Deleted RDU***********");
		
	}
}
