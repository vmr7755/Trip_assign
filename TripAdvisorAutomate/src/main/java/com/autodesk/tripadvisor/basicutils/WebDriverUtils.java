package com.autodesk.tripadvisor.basicutils;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementToClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void moveTo(WebDriver driver ,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void moveTo(WebDriver driver ,WebElement element,int xoffset ,int yoffset)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element,xoffset,yoffset).click().perform();
	}

	
	static String childId=null;
	static String parentId=null;
	
	public void switchToChildWindow(WebDriver driver) {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		parentId=it.next();
		childId=it.next();
		
		driver.switchTo().window(childId);
	}
	
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(parentId);
		
	} 
	
	public void switchToWindow(WebDriver driver,String title) {
		Set<String>s=driver.getWindowHandles();
		Iterator<String> i= s.iterator(); 
		while(i.hasNext())
		{
			
			if(!(driver.getTitle().equals(title)))
				driver.switchTo().window(i.next());
			else
				break;
		}
	}
	
	public void select(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
}
