package org.tb1;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactInIntegration extends BaseClass {

	@BeforeClass
	public static void beforeClass() {

		getDriver();

		enterUrl("https://adactinhotelapp.com/");

		windowMax();

		implicitlyWaits(10);
	}

	@AfterClass
	public static void afterClass() {
		closeAllWindow();
	}

	@Test
	public void bookHotel() throws IOException, InterruptedException {

		// 1.Login
		LoginPage loginPage = new LoginPage();

		loginPage.login(getDataFromExcel("Adactin", 1, 0), getDataFromExcel("Adactin", 1, 1));

		// 2.SearchHotel

		SearchHotelsPage searchhtl = new SearchHotelsPage();

		WebElement welcomeMsg = searchhtl.getTxtWelcomeMsg();
		String actWelcomeMsg = getAttribute(welcomeMsg);
	//	Assert.assertEquals("Verify after login Welcome Msg is present", "Hello Karthi87600!", actWelcomeMsg);

		searchhtl.searchHotels(getDataFromExcel("Adactin", 1, 2),

				getDataFromExcel("Adactin", 1, 3), getDataFromExcel("Adactin", 1, 4),

				getDataFromExcel("Adactin", 1, 5), getDataFromExcel("Adactin", 1, 6),

				getDataFromExcel("Adactin", 1, 7), getDataFromExcel("Adactin", 1, 8),

				getDataFromExcel("Adactin", 1, 9));

		// 3.SelectHotel

		SelectHotelPage Selecthtl = new SelectHotelPage();

		WebElement searchTitle = Selecthtl.getTxtSearchTitle();
		String textSearchTitle = getText(searchTitle);
		Assert.assertEquals("Verify after searchHotel Select Hotel is present", "Select Hotel", textSearchTitle);

		Selecthtl.selectHotel();

		// 4 BookHotel

		BookHotelPage bookHtl = new BookHotelPage();

		WebElement BookHotelTitle = bookHtl.getTxtBookHtlTitle();
		String textBookHotelTitle = getText(BookHotelTitle);
		Assert.assertEquals("Verify after selectHotel BookHotel is present", "Book A Hotel", textBookHotelTitle);

		bookHtl.bookHotel(getDataFromExcel("Adactin", 1, 10), getDataFromExcel("Adactin", 1, 11),

				getDataFromExcel("Adactin", 1, 12), getDataFromExcel("Adactin", 1, 13),

				getDataFromExcel("Adactin", 1, 14), getDataFromExcel("Adactin", 1, 15),

				getDataFromExcel("Adactin", 1, 16), getDataFromExcel("Adactin", 1, 17));

		// 5.Booking Confirmation

		BookingConfirmationPage bookConfirm = new BookingConfirmationPage();

		WebElement bookingConfirmTitle = bookConfirm.getTxtBookingConfirm();
		String textBookingConfirmTitle = getText(bookingConfirmTitle);
		Assert.assertEquals("Verify after bookHotel--BookConfirmation is present", "Booking Confirmation",textBookingConfirmTitle);

		bookConfirm.booking();

		// 6.Cancel Booking

		CancelBookingPage cancelBook = new CancelBookingPage();

		cancelBook.cancelled(getDataFromExcel("Adactin", 1, 19));

		WebElement bookingCancelText = cancelBook.getTxtCancelBooking();
		String textBookingCancelBooking = getText(bookingCancelText);
	Assert.assertEquals("Verify after BookingConfirm--Cancel is present", "The booking has been cancelled.",textBookingCancelBooking);

	}

	
	
	
	
}
