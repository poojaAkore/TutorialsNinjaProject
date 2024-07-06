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

public class Register extends Base{
	WebDriver driver;
	//public Properties prop;
	public Register() throws IOException
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{

		
		driver=InitialiseBrowserAndOpenApplicationUrl(prop.getProperty("BrowserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	@Test(priority=1)
	public void VerifyRegisteringanAccountwithMandstoryFields()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Ajinkya");
		driver.findElement(By.id("input-lastname")).sendKeys("Kore");
		driver.findElement(By.id("input-email")).sendKeys(Utility.genrateEmailwithTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1236547899");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ActualSuccessHeading=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(ActualSuccessHeading, "Register Account", "Your account is not created");
		
		
	}
	@Test(priority=2)
	public void VerifyRegisterAccountwithallFields()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Amruta");
		driver.findElement(By.id("input-lastname")).sendKeys("Kore");
		driver.findElement(By.id("input-email")).sendKeys(Utility.genrateEmailwithTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("5236987412");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String ActualSuccessHeading=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(ActualSuccessHeading, "Register Account", "Your account is not created");
	}
	
	@Test(priority=3)
	public void VerifyRegisterAccountWithExistingEmailAddress()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Amruta");
		driver.findElement(By.id("input-lastname")).sendKeys("Kore");
		driver.findElement(By.id("input-email")).sendKeys("anupat2593@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("5236987412");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String ActualWarningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(ActualWarningmsg, "Warning: E-Mail Address is already registered!", "Please enter new emailId");
	}
	
	@Test(priority=4)
	public void VerifyRegisteringAccountWithoutfillingAnyDetails()
	{
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String Actualprivacypolicywarningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(Actualprivacypolicywarningmsg.contains("Warning: You must agree to the Privacy Policy!"), "privacyPolicy Warning message is not displayed");
		
		String ActualFirstNameWarningMeassage=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(ActualFirstNameWarningMeassage, "First Name must be between 1 and 32 characters!","Firstname warning message is not displayed");
		
		
		String ActualLastNameWarningMeassage=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(ActualLastNameWarningMeassage, "Last Name must be between 1 and 32 characters!","Lasttname warning message is not displayed");
		
		String ActualEmailWarningMeassage=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(ActualEmailWarningMeassage, "E-Mail Address does not appear to be valid!","Email warning message is not displayed");
		
		String ActualTelephoneWarningMeassage=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(ActualTelephoneWarningMeassage, "Telephone must be between 3 and 32 characters!","Telephone warning message is not displayed");
		
		String ActualpasswordWarningMeassage=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(ActualpasswordWarningMeassage, "Password must be between 4 and 20 characters!","Password warning message is not displayed");
		
		
		
		
	}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}

}
