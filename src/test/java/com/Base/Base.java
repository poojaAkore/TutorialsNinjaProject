package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Base() throws IOException
	{
	    prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+
				"src\\main\\java\\com\\Propertiesfile\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(propfile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public WebDriver InitialiseBrowserAndOpenApplicationUrl(String BrowserName)
	{
		
		if(BrowserName.contains("Chrome"))
		{
			driver=new ChromeDriver();	
		}else if(BrowserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}else if(BrowserName.contains("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("Url");
		return driver;
	}

}
