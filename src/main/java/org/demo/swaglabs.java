package org.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class swaglabs {
    public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/ ");
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		WebElement Txtusername=driver.findElement(By.id("user-name"));
		Txtusername.sendKeys("standard_user");
		
		WebElement Txtpassword=driver.findElement(By.id("password"));
		Txtpassword.sendKeys("secret_sauce");
		
		Thread.sleep(1000);
		
		WebElement signinbtn =driver.findElement(By.id("login-button"));
		signinbtn.click();
		
		Thread.sleep(2000);
		
	    WebElement addtocart=driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
		addtocart.click();
		
		Thread.sleep(1000);
		
		WebElement cart=driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
		cart.click();

	    WebElement checkout=driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
		checkout.click();
		 
		Thread.sleep(3000);
		
	    WebElement TxtFirstname =driver.findElement(By.id("first-name"));
		TxtFirstname.sendKeys("ABINAYA");
		
		WebElement  Txtlastname=driver.findElement(By.id("last-name"));
		Txtlastname.sendKeys("S");
		
		WebElement pincode=driver.findElement(By.id("postal-code"));
		pincode.sendKeys("600096");
		
		Thread.sleep(1000);
		 
		WebElement continuebtn=driver.findElement(By.xpath("//input[@value='CONTINUE']"));
		continuebtn.click();
		 
		Thread.sleep(1000);
		
		
		WebElement finishbtn=driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
		finishbtn.click();
		
		
		
		
}

}
