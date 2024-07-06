package com.TNG.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyNewsLink {
	WebDriver driver;
	 @BeforeClass
	    public void setup() {
	       
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.jaguarlandrover.com/");
	    }
	 @Test
	 public void clickonNewslink()
	 {
		 driver.findElement(By.xpath("//*[@id=\"block-jlr-corporate-2024-mainpagecontent\"]/div[1]/div/div/div[9]/div/div/div[2]/a")).click();
		 Assert.assertTrue(driver.findElement(By.id("search-icon")).isDisplayed());
	 }
	 @AfterClass
	    public void teardown() {
	        // Close the browser
	       
	          driver.quit();
	        }



}
