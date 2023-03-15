package org.tb1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);	
		
		}

	@FindBy(id = "order_id_text")
	private WebElement txtSearchId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	
	@FindBy(name="ids[]")
	private WebElement checkBox;

	@FindBy(xpath ="(//input[contains(@value,'Cancel')])[1]")
	private WebElement btnCancel;
	
	@FindBy(xpath="//label[contains(text(),'The booking has been cancelled.')]")
	private WebElement txtCancelBooking;
	
	
	public WebElement getTxtSearchId() {
		return txtSearchId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}
	
	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public WebElement getTxtCancelBooking() {
		return txtCancelBooking;
	}

	public void cancelled(String att) throws IOException {
		

		sendKeys(getTxtSearchId(),att);

		clickElement(getBtnGo());
		
		clickElement(getCheckBox());

		clickElement(getBtnCancel());

		alertBoxOk();

	}


	
	
	
	
	
}
