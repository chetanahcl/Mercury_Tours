package com.mercury;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel_XLS {
	
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	
	//This method is to read the test data from Excel
	public String[][] getExcelData(String fileName,String sheetName) throws EncryptedDocumentException, IOException{
	String[][] arrayExcelData =null;
	FileInputStream ExcelFile = new FileInputStream(fileName);
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
	System.out.println(arrayExcelData);
	return arrayExcelData;
	

}
}