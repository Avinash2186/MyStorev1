package com.myStore.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myStore.utilities.XLUtils;

public class TC_LoginDDT_002 {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
			System.out.println("user::: "+user);
			System.out.println("pwd::: "+pwd);
			try {
				System.out.println("get data ====> "+getData()[0][0]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/myStore/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		//for(int i=1;i<=rownum;i++)
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				//logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				logindata[i][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
