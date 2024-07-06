package com.TNG.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;

public class Search extends Base{
	WebDriver driver;
	//public Properties prop;
	public Search(Properties prop) throws IOException
	{
		super();
		//prop=this.prop;
	}
	@BeforeMethod
	public void SetUP()
	{
		driver=InitialiseBrowserAndOpenApplicationUrl(prop.getProperty("BrowserName"));
	}
	
	@Test(priority=1)
	public void VerifySearchFunctionalitywithExistingProduct()
	{
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"product is not displayed");
		
	}
	
	@Test(priority=2)
	public void VerifySearchFunctionalitywithInvalidProduct()
	{
		driver.findElement(By.name("search")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		String ActualsearchMsg=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getTagName();
		Assert.assertEquals(ActualsearchMsg, "p","product is not available");
		
	}
	
	@Test(priority=3)
	public void verifySearchFunctionalitywithoutAnyProduct()
	{
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		String ActualsearchMsg=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getTagName();
		Assert.assertEquals(ActualsearchMsg, "p","product is not available");
		
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
