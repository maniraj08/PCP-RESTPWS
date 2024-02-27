package api.test;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.endpoits.COSOperations;
import api.payload.COSPayload;
import api.payload.RestRdu;
import io.restassured.response.Response;

public class COSTest {

	String Sid;
	RestRdu rdupayload;
	COSPayload COSPL;
	HashMap COSProperties;
	
	public Logger logger;
	
	@BeforeClass()
	public void CSInputData()
	{
		
		//payload for createSession
		rdupayload=new RestRdu();
		rdupayload.setRduHost("pcp-lnx-124");
		rdupayload.setUsername("admin");
		rdupayload.setPassword("admin123");
		rdupayload.setRduPort("49188");
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
	
	
	@Test(priority=1)
	public void testCreateSession()
	{
		
		logger.info("************* Creating Session **********");
		
		Response response=COSOperations.CreateSession(rdupayload);
		
		//this will get the session id from response
		 Sid=response.path("sessionId");
		 response.then().log().all();
	
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 logger.info("*************  Session Created **********");
	}
	
	
	@BeforeMethod()
	public void COSInputdata()
	{
		//payload for addCOS
		 COSPL=new COSPayload();
		 COSPL.setDeviceType("DOCSISModem");
		 COSPL.setName("testCOS8");
		 COSPL.setSessionId(Sid);
		 
         COSProperties =new HashMap ();
	
		 COSProperties.put("/cos/docsis/file", "gold.cm");
		 COSProperties.put("/fqdn/auto/enable", "true");
		 COSProperties.put("/fqdn/domain", "cisco.com");
		 
		 COSPL.setProperties(COSProperties);
	}
	
	
	@Test(priority=2, dependsOnMethods= {"testCreateSession"})
	public void testAddCOS()
	{
		 
		 Response response=COSOperations.AddCOS(COSPL);
		 
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 logger.info("************* COS ADDED SUCCESSFULLY  **********");
	}
	

	@Test(priority=3, dependsOnMethods= {"testCreateSession"})
	public void testGetCOS()
	{
		
		COSPL.setSessionId(Sid);
		COSPL.setResourceName(COSPL.getName());
		
		 logger.info("************* GET COS Details  **********");
		 
		 Response response=COSOperations.GetCOS(COSPL);
		 
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
	@Test(priority=4, dependsOnMethods= {"testCreateSession"})
	public void testUpdateCOS()
	{
		
		COSPL.setSessionId(Sid);
		COSPL.setResourceName(COSPL.getName());
		
		COSProperties.put("/fqdn/domain", "mani.com");
		COSPL.setProperties(COSProperties);
		
		 Response response=COSOperations.UpdateCOS(COSPL);
		 
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		
		 logger.info("************* UPDATED COS Details  **********");
		 
		 //GetCoS after update
		 
		 logger.info("************* GET COS Details after successful Update **********");
        Response getresponse=COSOperations.GetCOS(COSPL);
		 
		 getresponse.then().log().all();
		 
		 
	}
	
	@Test(priority=5, dependsOnMethods= {"testCreateSession"})
	public void testDeleteCOS()
	{
		
		COSPL.setSessionId(Sid);
		COSPL.setResourceName(COSPL.getName());
		
		 Response response=COSOperations.DeleteCOS(COSPL);
		 
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 logger.info("************* COS DELETED SUCCESSFULLY  **********");
		 
		 //GetCoS after Delete
	        Response getresponse=COSOperations.GetCOS(COSPL);
			 
			 getresponse.then().log().all();
			 
			 logger.info("************* THE DELETED COS IS NOT IN DB  **********");
	}
	
	
}
