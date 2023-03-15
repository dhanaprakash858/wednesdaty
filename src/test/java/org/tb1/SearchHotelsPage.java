package org.tb1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelsPage extends BaseClass {

	
	public SearchHotelsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement txtWelcomeMsg;

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotels;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNos;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckIn;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOut;

	@FindBy(id = "adult_room")
	private WebElement dDnAdultRoom;

	@FindBy(id = "child_room")
	private WebElement dDnChildRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNos() {
		return dDnRoomNos;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	
		public void searchHotels(String location, String hotels, String roomtype, String roomnos, String checkin, String checkout, String adultroom, String childroom) {
			
			selectByVisibleText(getdDnLocation(), location);
			
			selectByVisibleText(dDnHotels, hotels);
			
			selectByVisibleText(getdDnRoomType(), roomtype);
			
			selectByVisibleText(getdDnRoomNos(), roomnos);
			
			sendKeys(getTxtCheckIn(), checkin);
			
			sendKeys(getTxtCheckOut(), checkout);
			
			selectByVisibleText(getdDnAdultRoom(), adultroom);
			
			selectByVisibleText(getdDnChildRoom(), childroom);
			
			clickElement(getBtnSearch());
			
			
	
			
		}
}
