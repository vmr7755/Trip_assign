package tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.tripadvisor.basicutils.WebDriverUtils;

public class ResultsPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[.='Club Mahindra Madikeri, Coorg']/../following-sibling::div/div/span")
	private WebElement firstReviewSearch;
	
	
	
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void writeReview()
	{
		WebDriverUtils wlib=new WebDriverUtils();
		firstReviewSearch.click();
		wlib.switchToChildWindow(driver);
		HotelPage hp=new HotelPage(driver);
		hp.writeReview();
		wlib.switchToParentWindow(driver);
	}

}
