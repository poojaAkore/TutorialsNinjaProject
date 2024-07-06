package com.TNG.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTextOnHomePage {
	
	public class VerifyLearnMoreButton {
		WebDriver driver;
		@BeforeClass
	    public void setup() {
	       
	        driver = new ChromeDriver();
	        driver.manage().window().maximize(); 
	        driver.get("https://www.jaguarlandrover.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
		
		@Test
		public void VerifyLearnMoreButton() 
		{
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,300)");
			
	String ActText=driver.findElement(By.xpath("//div[@class='texts__item texts__item--col-1 ']/p[2]")).getText();
	String expText="Our vision is to be proud creators of the most desirable, modern luxury brands, for the most discerning of clients.";
	Assert.assertEquals(ActText, expText);
	
		}
		 @AfterClass
		    public void teardown() {
		        // Close the browser
		       
		            driver.quit();
		       
		    }
}}
