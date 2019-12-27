package com.mercury;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_xls_xlsx {
	
	
	
	//This method is to read the test data from Excel
	@SuppressWarnings("resource")
	public String[][] getExcelData(String fileName,String sheetName) throws IOException{
	String[][] arrayExcelData =null;
	FileInputStream ExcelFile = new FileInputStream(fileName);
	String fileExtensionName = fileName.substring(fileName.indexOf("."));
	if(fileExtensionName.equals(".xlsx")){
		 XSSFSheet ExcelWSheet;
		 XSSFWorkbook ExcelWBook;
		//If it is xlsx file then create object of XSSFWorkbook class
		//	KDWorkbook = new XSSFWorkbook(inputStream);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet =ExcelWBook.getSheet(sheetName);
		int tottalNoOfRows =ExcelWSheet.getLastRowNum();
		int totalNoOfCol_0 = ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData =new String [tottalNoOfRows][totalNoOfCol_0];
		for(int i=0;i<tottalNoOfRows;i++)
		{
			int totalNoOfCol = ExcelWSheet.getRow(i).getLastCellNum();
			
			for(int j=0;j<totalNoOfCol;j++)
			{
				arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(arrayExcelData[i][j]);
			}
		}	
		
		}
	else if(fileExtensionName.equals(".xls")){
		Sheet ExcelWSheet;
		Workbook ExcelWBook;
		//If it is xls file then create object of XSSFWorkbook class
		ExcelWBook =WorkbookFactory.create(ExcelFile);
		ExcelWSheet =ExcelWBook.getSheet(sheetName);
		int tottalNoOfRows =ExcelWSheet.getLastRowNum();
		int totalNoOfCol_0 = ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData =new String [tottalNoOfRows][totalNoOfCol_0];
		for(int i=0;i<tottalNoOfRows;i++)
		{
			int totalNoOfCol = ExcelWSheet.getRow(i).getLastCellNum();
			
			for(int j=0;j<totalNoOfCol;j++)
			{
				arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(arrayExcelData[i][j]);
			}
		}	
		
	}
	System.out.println(arrayExcelData);
	return arrayExcelData;
	
	

}
	/*//combining xls and xlsx 
	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
	//Create a object of File class to open xlsx file
	File file =	new File(filePath+"\\"+fileName);
	//Create an object of FileInputStream class to read excel file
	FileInputStream inputStream = new FileInputStream(file);
	Workbook KDWorkbook = null;
	//Find the file extension by spliting file name in substing and getting only extension name
	String fileExtensionName = fileName.substring(fileName.indexOf("."));
	//Check condition if the file is xlsx file
	if(fileExtensionName.equals(".xlsx")){
	//If it is xlsx file then create object of XSSFWorkbook class
		KDWorkbook = new XSSFWorkbook(inputStream);
	}
	//Check condition if the file is xls file
	else if(fileExtensionName.equals(".xls")){
		//If it is xls file then create object of XSSFWorkbook class
		KDWorkbook = new HSSFWorkbook(inputStream);
	}
	//Read sheet inside the workbook by its name
	Sheet  TestSheet = KDWorkbook.getSheet(sheetName);
	 return TestSheet;	
	}*/
}