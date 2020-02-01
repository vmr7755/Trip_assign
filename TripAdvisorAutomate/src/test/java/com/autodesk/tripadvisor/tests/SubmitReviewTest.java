package com.autodesk.tripadvisor.tests;

import org.testng.annotations.Test;

import com.autodesk.tripadvisor.basicutils.RootClass;

import tripadvisor.pages.ResultsPage;
import tripadvisor.pages.TripAdvisorHomePage;

public class SubmitReviewTest extends RootClass {
	
	@Test
	public void submitReviewTest()
	{
		TripAdvisorHomePage tahp = new TripAdvisorHomePage(driver);
	 ResultsPage rp = tahp.searchFor("club mahindra");
	 rp.writeReview();
		
	}

}
