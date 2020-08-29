package com.qa.util;

import java.util.ArrayList;

import com.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long implicitly_Wait=30;
	public static long pageLoad_Timeout= 30;
	
	public static String newAccType= "Savings";	//"Current";
	
	

	static Xls_Reader reader;
	static String sheetname = "Sheet1";
	
	public static ArrayList<Object[]> getLoginDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try 
		{
			reader = new Xls_Reader("C:\\Users\\Samsung\\eclipse-workspace\\Guru99Bank\\src\\main\\java\\com\\qa\\testdata\\LoginData.xlsx");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int rownmbr=2; rownmbr <= reader.getRowCount(sheetname); rownmbr++)
		{
			String username = reader.getCellData(sheetname, 0, rownmbr);

			String password = reader.getCellData(sheetname, 1, rownmbr);
			
			Object[] obj = {username,password};
			myData.add(obj);

		}
		return myData;
	
	}	
}