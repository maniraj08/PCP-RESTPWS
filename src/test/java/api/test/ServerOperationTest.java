package api.test;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.endpoits.COSOperations;
import api.endpoits.ServerOperations;
import api.payload.COSPayload;
import api.payload.RestRdu;
import api.payload.ServerOperationsPayload;
import io.restassured.response.Response;

public class ServerOperationTest {

	RestRdu rdupayload;
	String Sid;
	ServerOperationsPayload payload;
	public Logger logger;
	HashMap changedefProp;
	
	@BeforeClass()
	public void CSInputData()
	{
		
		//payload for createSession
		rdupayload=new RestRdu();
		rdupayload.setRduHost("pcp-dpe-1");
		rdupayload.setUsername("admin");
		rdupayload.setPassword("admin123");
		rdupayload.setRduPort("49188");
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
	
	
	@Test(priority=1)
	public void testCreateSession()
	{
		
		Response response=COSOperations.CreateSession(rdupayload);
		
		//this will get the session id from response
		 Sid=response.path("sessionId");
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 logger.info("*************  Session created **********");
	}
	
	@BeforeMethod()
	public void ServerInputdatas()
	{
		//payload for cnrs
		payload=new ServerOperationsPayload();
		payload.setSessionId(Sid);
	}
	
	
	@Test(priority=2)
	public void testGetAllCnrs()
	{
		logger.info("************* All CNRs Details **********");
		
		Response response=ServerOperations.getAllCNRs(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testGetAllDpes()
	{
		logger.info("************* All DPEs Details**********");
		payload.setSessionId(Sid);
		
		Response response=ServerOperations.getAllDPEs(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testgetAllProvGrps()
	{
		logger.info("************* All Prov Groups Details **********");
		payload.setSessionId(Sid);
		
		Response response=ServerOperations.getAllProvGrps(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=5)
	public void testgetCNRDetails()
	{
		logger.info("************* CNR Detail **********");
		payload.setSessionId(Sid);
		payload.setHostName("pcp-dpe-2.cisco.com");
		
		Response response=ServerOperations.getCNRDetails(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=6)
	public void testgetDefaults()
	{
		logger.info("************* Defaults Details**********");
		payload.setSessionId(Sid);
		payload.setDeviceTypeName("DOCSISModem");
		
		Response response=ServerOperations.getDefaults(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=7)
	public void testgetDPEDefaults()
	{
		logger.info("************* DPE Defaults Details **********");
		payload.setSessionId(Sid);
		payload.setHostName("pcp-dpe-2.cisco.com");
		
		Response response=ServerOperations.getDPEDefaults(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=8)
	public void testgetDPEDetails()
	{
		logger.info("************* DPE Details **********");
		payload.setSessionId(Sid);
		payload.setHostName("pcp-dpe-2.cisco.com");
		
		Response response=ServerOperations.getDPEDetails(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=9)
	public void testgetExtenPointSettings()
	{
		logger.info("************* ExtenPointSettings Details **********");
		payload.setSessionId(Sid);
		
		Response response=ServerOperations.getExtensionPointSettings(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=10)
	public void testchangeDetafuls()
	{
		logger.info("************* changeDetafuls Details **********");
		//payload
		payload.setSessionId(Sid);
		payload.setDeviceTypeName("DOCSISModem");
		changedefProp=new HashMap();
		changedefProp.put("/docsis/cmts/version/default", "2.0");
		changedefProp.put("/dualStack/provisioning/mode/enable", "true");
		payload.setPropertiesToAdd(changedefProp);
		
		Response response=ServerOperations.changeDefaults(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=11)
	public void testchangeRDUDetafuls()
	{
		logger.info("************* changeRDUDetafuls Details **********");
		//payload
		payload.setSessionId(Sid);
		changedefProp=new HashMap();
		changedefProp.put("/server/offline/dpe/delete", "true");
		changedefProp.put("/auth/number/sessions/user", "100");
		payload.setProperties(changedefProp);
		
		Response response=ServerOperations.changeRDUDefaults(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
