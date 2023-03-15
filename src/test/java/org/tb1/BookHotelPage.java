package org.tb1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);	
		
		}

	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHtlTitle;
	
	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditNo;

	@FindBy(id = "cc_type")
	private WebElement dDnCreditType;

	@FindBy(id = "cc_exp_month")
	private WebElement dDnExpiryMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement dDnExpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	
	public WebElement getTxtBookHtlTitle() {
		return txtBookHtlTitle;
	}

	public void setTxtBookHtlTitle(WebElement txtBookHtlTitle) {
		this.txtBookHtlTitle = txtBookHtlTitle;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditNo() {
		return txtCreditNo;
	}

	public WebElement getdDnCreditType() {
		return dDnCreditType;
	}

	public WebElement getdDnExpiryMonth() {
		return dDnExpiryMonth;
	}

	public WebElement getdDnExpiryYear() {
		return dDnExpiryYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String firstName, String lastName, String address, String ccNo, String ccType,
			String ccExpMonth, String ccExpYear, String cvvNo) throws InterruptedException {

		sendKeys(getTxtFirstName(), firstName);

		sendKeys(getTxtLastName(), lastName);

		sendKeys(getTxtAddress(), address);

		sendKeys(getTxtCreditNo(), ccNo);

		sendKeys(getdDnCreditType(), ccType);

		sendKeys(getdDnExpiryMonth(), ccExpMonth);

		sendKeys(getdDnExpiryYear(), ccExpYear);

		sendKeys(getTxtCvv(), cvvNo);

		clickElement(getBtnBookNow());

		Thread.sleep(3000);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
