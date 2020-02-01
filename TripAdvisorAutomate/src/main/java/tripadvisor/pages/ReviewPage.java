package tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.tripadvisor.basicutils.WebDriverUtils;

public class ReviewPage {

	WebDriver driver;

	@FindBy(id="bubble_rating")
	private WebElement yourOverAllRatingSec;

	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_00']")
	private WebElement rateStarForOverallSec;

	@FindBy(id="ReviewTitle") private WebElement reviewTitleTextBox;

	@FindBy(id="ReviewText")private WebElement reviewTextBox;

	@FindBy(xpath="//div[.='Business']") private WebElement businessBoxInSortOfTrip;

	@FindBy(id="trip_date_month_year") private WebElement tripTravelDate;

	@FindBy(id="qid12_bubbles") private WebElement rateStarForServiceSec;

	@FindBy(id="qid14_bubbles") private WebElement rateStarForCleanlinessSec;

	@FindBy(id="qid11_bubbles") private WebElement rateStarForRoomsSec;

	@FindBy(id="qid190_bubbles") private WebElement rateStarForSleepQualitySec;

	@FindBy(id="qid13_bubbles") private WebElement rateStarForValueSec;

	@FindBy(id="noFraud") private WebElement submitReviewCheckBox;

	@FindBy(xpath="//div[.='Hotel Ratings']") private WebElement hotelRating;

	@FindBy(id="SUBMIT") private WebElement submitYourReviewBttn;

	public ReviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void submitReview(String reviewtitle,String reviewText)
	{
		WebDriverUtils wlib=new WebDriverUtils();
		wlib.moveTo(driver,yourOverAllRatingSec,50,0);

		reviewTitleTextBox.sendKeys(reviewtitle);
		reviewTextBox.sendKeys(reviewText);
		businessBoxInSortOfTrip.click();
		wlib.select(tripTravelDate,"December 2019");
		if(hotelRating.isDisplayed())
		{
			try
			{
				wlib.moveTo(driver,rateStarForServiceSec,40,0);
				wlib.moveTo(driver,rateStarForCleanlinessSec,40,0);
				wlib.moveTo(driver,rateStarForRoomsSec,40,0);
				wlib.moveTo(driver,rateStarForSleepQualitySec,40,0);
				wlib.moveTo(driver,rateStarForValueSec,45,0);
			}
			catch(Exception e)
			{

			}
		}
		submitReviewCheckBox.click();
		submitYourReviewBttn.click();    
	}

}
