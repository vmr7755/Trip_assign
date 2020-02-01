package com.autodesk.tripadvisor.basicutils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RootClass implements IAutoConstant{
	public WebDriver driver;
	public FileUtils flib= new FileUtils();
	public WebDriverUtils wlib = new WebDriverUtils();
	
	static {
		System.setProperty(CHROME_KEY,CHROME_PATH);
		System.setProperty(GECKO_KEY,GECKO_PATH);
	}

	@BeforeClass
	public void openBrowser() throws IOException
	{
		String browser=flib.getDataFromProperties("browser");
		String url=flib.getDataFromProperties("url");
		
		if(browser.equals("chrome"))
			driver= new ChromeDriver();
		else if(browser.equals("firefox"))
			driver= new FirefoxDriver();
		driver.get(url);
		wlib.maximize(driver);
		wlib.waitForLoad(driver);
		
		
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	
	
}
