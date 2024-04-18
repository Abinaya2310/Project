
package org.demo;

	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class Logins {
		
		@Test(dataProvider="credentials")
		public void verifyLoginCredentials(String scenario, String username,String password) {
			                                                                                        
			
			//WebDriver.chromedriver().setup();		
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://demowebshop.tricentis.com/login");
			
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.id("Password")).sendKeys(password);
			

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//WebElement myButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Log in']")));
			//myButton.click();
			
			
			driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input")).click();
			
			if(scenario.equals("bothCorrect")) {
			WebElement account = driver.findElement(By.className("account"));
			
	        Assert.assertTrue(account.isDisplayed(),"Login not Success");
				
			}
			else if(scenario.equals("bothWrong")) {
				
		    String errorMessage=driver.findElement(By.cssSelector("div[class='validation-summary-errors'] span")).getText();
		    Assert.assertEquals(errorMessage, " No customer account found");
			}
			else if(scenario.equals("correctusername")) {
			
		    String errorMessage=driver.findElement(By.cssSelector("div[class='validation-summary-errors'] span")).getText();
		    Assert.assertEquals(errorMessage, "The credentials provide are incorrect");
				
				}
			
//			else {
//				String errorMessage=driver.findElement(By.cssSelector("div[class='validation-summary-errors'] span")).getText();
//				Assert.assertEquals(errorMessage, " No customer account found");
//			 }

	          driver.quit();
			
	         }
			@DataProvider(name="credentials")
		    public Object [][] getData(){
			 
			 return new Object [][] {
		
			{"bothcorrect","abi23.subramanian@gmail.com","SAbi@23"},
			{"bothwrong","abi26.subramanian@gmail.com","sabi123"},
			{"Correctusername","abi23.subramanian@gmail.com","123abi"},	
		//	{"Correctpaswword","abinaya23.subramanian@gmail","SAbi@23"}
			
			 };
			
			 
		
		 



		

	}

}
