package org.tb1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage extends BaseClass {
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);	
		
		}

	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingConfirm;

	@FindBy(id = "order_no")
	private WebElement txtOrderId;
	
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement lnkItinerary;

	
	public WebElement getTxtBookingConfirm() {
		return txtBookingConfirm;
	}


	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getLnkItinerary() {
		return lnkItinerary;
	}

	public void booking() throws IOException {

		String att = getAttribute(getTxtOrderId());
		
		writeCellData("Adactin", 1,19,att);
		
		clickElement(getLnkItinerary());
		
	}

}
