package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.DriverUtils;
import helpers.ElementsUtils;
import helpers.Logger;

public class BookTicketPage extends BasePage{
	
	String departFromSelectorLocator = "//select[@name='DepartStation']";
	String arriveStationLocator = "//select[@name='ArriveStation']";
	String quantityTicketLocator = "//select[@name='TicketAmount']";
	String bookTicketButtonLocator = "//input[@value='Book ticket']";
	String departDateSelectorLocator = "//select[@name='Date']";
	String seatTypeSelectorLocator = "//select[@name='SeatType']";
	
	Select departFromSelector;
	Select arriveAtSelector;
	Select amountSelector;
	Select departDateSelector;
	Select seatTypeSelector;
	WebElement bookTicketButton;
	
	public BookTicketPage() 
	{
		pageTitle = "Safe Railway - Book Ticket";
	}
	
	public void selectDepartFrom(String locationName) {
		Logger.log("Select depart location:"+locationName);
		departFromSelector = new Select(DriverUtils.driver.findElement(By.xpath(departFromSelectorLocator)));
		ElementsUtils.scrollIntoView(DriverUtils.driver.findElement(By.xpath(departFromSelectorLocator)));
		departFromSelector.selectByVisibleText(locationName);
	}
	
	public void selectArriveTo(String locationName) {
		Logger.log("Select arrive location:"+locationName);
		arriveAtSelector = new Select(DriverUtils.driver.findElement(By.xpath(arriveStationLocator)));
		ElementsUtils.waitForElementClickable(By.xpath(arriveStationLocator), 60);
		ElementsUtils.scrollIntoView(DriverUtils.driver.findElement(By.xpath(arriveStationLocator)));
		arriveAtSelector.selectByVisibleText(locationName);
	}
	
	public void selectSeatType(String seatType) {
		Logger.log("Select seattype:"+seatType);
	seatTypeSelector = new Select(DriverUtils.driver.findElement(By.xpath(seatTypeSelectorLocator)));
	ElementsUtils.scrollIntoView(DriverUtils.driver.findElement(By.xpath(seatTypeSelectorLocator)));
	seatTypeSelector.selectByVisibleText(seatType);
	}
	public void selectTicketQuantity(String quantity) {
		Logger.log("Select quantity:"+quantity);

		amountSelector = new Select(DriverUtils.driver.findElement(By.xpath(quantityTicketLocator)));
		ElementsUtils.scrollIntoView(DriverUtils.driver.findElement(By.xpath(quantityTicketLocator)));
		amountSelector.selectByVisibleText(quantity);
	}
	
	public void selectDepartDate(String departDate) {
		Logger.log("Select depart date:"+departDate);

		departDateSelector = new Select(DriverUtils.driver.findElement(By.xpath(departDateSelectorLocator)));
		ElementsUtils.scrollIntoView(DriverUtils.driver.findElement(By.xpath(departDateSelectorLocator)));
		departDateSelector.selectByVisibleText(departDate);
	}
	public void clickBookTicketButton() {
		Logger.log("Click bookticket");

		bookTicketButton = DriverUtils.driver.findElement(By.xpath(bookTicketButtonLocator));
		ElementsUtils.scrollIntoView(bookTicketButton);
		bookTicketButton.click();
	}
}
