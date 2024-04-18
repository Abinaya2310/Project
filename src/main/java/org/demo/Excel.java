package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {


		public static void main(String[]args) throws Exception  {
			
			//@DataProvider(name="loginData")
		    //public String[][]getData() throws Exception {
			//	public static void main(String[] args) throws Exception {
					
			File excelfile =new File("./src/main/java/Test.xlsx");
			//System.out.println(excelfile.exists());
			FileInputStream fis = new FileInputStream(excelfile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheet("Sheet1");
						
			int noOfRows=sheet.getPhysicalNumberOfRows();
			//System.out.println(sheet.getLastRowNum());
						
			int noOfColumns = sheet.getRow(0).getLastCellNum();
			String[][] data= new String [noOfRows-1][noOfColumns];
						
			for (int i=0;i<noOfRows-1;i++) {
		    for (int j=0;j<noOfColumns;j++) {
								 
			DataFormatter df= new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
							 
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());		 
			}
							 
		    System.out.println();	 
							 
			}
			for (String[]dataArr:data) {
			System.out.println(Arrays.toString(dataArr));	
			}
//			 return data;
			}}


