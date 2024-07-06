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
import com.Utilities.Utility;


public class Login extends Base{

	WebDriver driver;
	//public Properties prop;
	public Login() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=InitialiseBrowserAndOpenApplicationUrl(prop.getProperty("BrowserName"));
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@Test(priority=1)
	public void VerifyLoginFunctionality()
	{
	    
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmailId"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	
}
	
	@Test(priority=2)
	public void VerifyInvalidLoginFunctionality()
	{
		driver.findElement(By.id("input-email")).sendKeys(Utility.genrateEmailwithTimestamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningmsg=driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpWarningmsg="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(ActualWarningmsg.contains(ExpWarningmsg), "expected warning message is not displayed");
		
	
	}
	
	@Test(priority=3)
	public void verifyInvalidEmailAddressandvalidpassword()
	{
		driver.findElement(By.id("input-email")).sendKeys(Utility.genrateEmailwithTimestamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningmsg=driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpWarningmsg="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(ActualWarningmsg.contains(ExpWarningmsg), "expected warning message is not displayed");
		
		
	}
	
	@Test(priority=4)
	public void VerifyValidEmailIdandInvalidpassword()
	{
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmailId"));
		driver.findElement(By.id("input-password")).sendKeys(Utility.genrateEmailwithTimestamp());
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningmsg=driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpWarningmsg="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(ActualWarningmsg.contains(ExpWarningmsg), "expected warning message is not displayed");
	
	}
	
	@Test(priority=5)
	public void VerifyLoginfunctionalitywithnullcrdentials()
	{
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningmsg=driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpWarningmsg="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(ActualWarningmsg.contains(ExpWarningmsg), "expected warning message is not displayed");

	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
}