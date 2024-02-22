package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoits.RestPWSOperationEndpoints;
import api.payload.RestRdu;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=Dataproviders.class)
	public void TestAddrduFromXL(String rduhost, String rduPort, String Uname, String Pwd)
	{
		RestRdu rdupayload=new RestRdu();
		
		rdupayload.setRduHost(rduhost);
		rdupayload.setRduPort(rduPort);
		rdupayload.setUsername(Uname);
		rdupayload.setPassword(Pwd);
		
		Response response=RestPWSOperationEndpoints.AddRDU(rdupayload,"test","test123");
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	
	@Test(priority=2)
	public void TestGetAllRdu()
	{
		
		Response response=RestPWSOperationEndpoints.GetRDU("test","test123");

		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3, dataProvider="rduHost", dataProviderClass=Dataproviders.class)
	public void DeleteAllRdu(String rduhost)
	{
		Response response=RestPWSOperationEndpoints.RemoveRDU(rduhost,"test","test123");

		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}
}
