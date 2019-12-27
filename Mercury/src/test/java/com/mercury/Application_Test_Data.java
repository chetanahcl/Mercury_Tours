package com.mercury;

import org.testng.annotations.DataProvider;

public class Application_Test_Data {
	
	@DataProvider(name ="Login")
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][]
				{
			
			{"testing","testing"},
			{"dixit","dixit"},
			{"testahi","testabhi"}
				};
	
	}
	@DataProvider(name ="LoginDataXLS")
	public Object[][] ExcelXLS() throws Exception
	{
		ReadExcel_xls_xlsx excel =new ReadExcel_xls_xlsx();
		Object[][] testObjArray =excel.getExcelData("C:\\Selenium_Training\\Workspace\\Mercury\\Mercury_Tours.xls", "Sign-On");
		System.out.println(testObjArray);
		return testObjArray;
	}
	
	@DataProvider(name ="LoginDataXLSX")
	public Object[][] ExcelXLSX() throws Exception
	{
		ReadExcel_XLSX excel =new ReadExcel_XLSX();
		Object[][] testObjArray =excel.getExcelData("C:\\Selenium_Training\\Workspace\\Mercury\\Mercury_Tours.xlsx", "Sign-On");
		System.out.println(testObjArray);
		return testObjArray;
	}
}
