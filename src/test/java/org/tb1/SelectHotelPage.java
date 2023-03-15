package org.tb1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);	
		
		}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSearchTitle;
	
	@FindBy(id = "radiobutton_0")
	private WebElement btnSelectHotel;

	@FindBy(id = "continue")
	private WebElement btnContinue;
	
	

	public WebElement getTxtSearchTitle() {
		return txtSearchTitle;
	}


	public WebElement getBtnSelectHotel() {
		return btnSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {
		clickElement(getBtnSelectHotel());
		clickElement(getBtnContinue());
	}

}
