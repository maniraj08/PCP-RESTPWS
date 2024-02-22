package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

//This method will retrive all datas
public class Dataproviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//AddrduData.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1",1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
//This method will retrive only rduhost names 
	@DataProvider(name="rduHost")
	public String[] getSingleUser() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//AddrduData.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 0);
		}

		return apidata;

	}

}
