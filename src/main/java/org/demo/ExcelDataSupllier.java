package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

          public class ExcelDataSupllier {

	      @Test(dataProvider="loginData")
	      public void TestLogin(String username, String password) throws Exception {
	      //WebDriverManager.chromedriver().setup();
	      WebDriver driver= new ChromeDriver();
		  //driver.manage().window().maximize();
		  // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  driver.get("https://demowebshop.tricentis.com/login ");
			
		  //driver.manage().deleteAllCookies();
			
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("Email")).sendKeys(username);
		  driver.findElement(By.id("Password")).sendKeys(password);
			
		  driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input")).click();
		  //Assert.assertTrue(driver.findElement(By.className("account")).isDisplayed());
		 
          driver.findElement(By.className("account")).isDisplayed();
         
          //AssertJUnit.assertTrue(driver.findElement(By.className("account")).isDisplayed());
		  Thread.sleep(5000);
		
		  driver.quit();
			}

          @DataProvider(name="loginData")
          public String[][]getData() throws Exception {
			//public static void main(String[] args) throws Exception {
			
	       File excelfile =new File("./src/main/java/org/demo/Test.xlsx");
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
	        return data;

            }}
