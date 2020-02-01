package tripadvisor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.tripadvisor.basicutils.WebDriverUtils;

public class TripAdvisorHomePage {
WebDriver driver;
	
	@FindBy(xpath="//span[.='Search']")
	private WebElement searchTextBox;
	
	@FindBy(id="mainSearch")
	private WebElement mainSearchTextBox;
	
	@FindBy(xpath="//input[@title='Search']")
	private WebElement ansearchTextBox;
	
	public TripAdvisorHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
	public ResultsPage searchFor(String s) 
	{
		WebDriverUtils wlib=new WebDriverUtils();
		
		try {
			wlib.waitForVisibility(driver,searchTextBox);
			wlib.moveTo(driver,searchTextBox);
		searchTextBox.click();
		mainSearchTextBox.sendKeys(s,Keys.ENTER);
		}
		catch(Exception c ){
			ansearchTextBox.sendKeys(s,Keys.ENTER);
		}
		
		return new ResultsPage(driver);
	}
	

}
