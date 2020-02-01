package tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.tripadvisor.basicutils.WebDriverUtils;

public class HotelPage {
WebDriver driver;
	
	@FindBy(linkText="Write a review")
	private WebElement writeReviewButton;
	
	@FindBy(id="mainSearch")
	private WebElement mainSearchTextBox;
	
	public HotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void writeReview()
	{
		WebDriverUtils wlib=new WebDriverUtils();
		writeReviewButton.click();
		wlib.switchToWindow(driver," Write a review - Tripadvisor ");
		ReviewPage rp=new ReviewPage(driver);
		rp.submitReview("sample","dfzihvmzl;kjbvgfm fxk;lofik ;lzdfmbokgfm l;fbjo;sgvmzlk xnkuvhcifdk jncxkuvhifjn x,chvilujb ncbvkfudn jckxbvfuidhvjc hbxkuygalisdkjdx;asouifiagvbcjhxbkjshfugvbcxjhzbcsuasifyrabcjshsduaweekdchaksdgfaerifiu");
	    
	}
    

}
