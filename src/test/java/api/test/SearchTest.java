package api.test;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.endpoits.COSOperations;
import api.endpoits.SearchOperations;
import api.payload.RestRdu;
import api.payload.SearchOperationPayload;
import api.payload.ServerOperationsPayload;
import io.restassured.response.Response;

public class SearchTest {

	RestRdu rdupayload;
	String Sid;
	SearchOperationPayload payload;
	public Logger logger;
	
	
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
	public void COSInputdatas()
	{
		//payload for cnrs
		payload=new SearchOperationPayload();
		payload.setSessionId(Sid);
		payload.setDeviceType("Computer");
		payload.setQuery("CosSearchByDeviceType");
	}
	
	@Test(priority=2)
	public void testCOSSearch()
	{
		 logger.info("*************  COS Search Details **********");
		Response response=SearchOperations.cosSearch(payload);
		
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
	@Test(priority=3)
	public void testDhcpSearch()
	
	{
		payload.setSessionId(Sid);
		payload.setQuery("DHCPCriteriaSearch");
		
		 logger.info("*************  DHCP Search Details **********");
		 
		Response response=SearchOperations.dhcpSearch(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
	@Test(priority=4)
	public void testFileSearch()
	
	{
		payload.setSessionId(Sid);
		payload.setQuery("FileSearchByFileType");
		payload.setFileType("MIB");
		payload.setName("bridge-mib");
		payload.setMaxResults(1);
		
		 logger.info("*************  File Search Details **********");
		 
		Response response=SearchOperations.fileSearch(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	

	@Test(priority=5)
	public void testGroupSearch()
	
	{
		payload.setSessionId(Sid);
		payload.setQuery("GroupSearchByGroupType");
		payload.setGroupNamePattern("system-diagnostics*");
		payload.setName("system");
		payload.setMaxResults(10);
		
		 logger.info("*************  Group Search Details **********");
		 
		Response response=SearchOperations.groupSearch(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
	@Test(priority=6)
	public void testSearchDevices()
	
	{
		payload.setSessionId(Sid);
		payload.setQuery("DeviceSearchByGroupName");
		payload.setStart("1,6,f0:00:00:00:00:01");
		payload.setName("system-diagnostics");
		payload.setMaxResults(1);
		payload.setReturnParameters("ALL");
		
		 logger.info("*************   Search Devices Details **********");
		 
		Response response=SearchOperations.SearchDevices(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		 
		
	}
	
}
