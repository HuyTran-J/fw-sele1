package pageobjects;

import org.openqa.selenium.By;

import helpers.DriverUtils;

public class TicketPricePage extends BasePage{
	
	public TicketPricePage() 
	{
		pageTitle = "Safe Railway - Train ticket price list";
	}
	
	private String dynamicBookTicketLocator = "//tr[td[text()='%s']]//td/a[text()='Book ticket']";
	private String seatTypeTblLocator = "//table[starts-with(@class,'MyTable')]//th[normalize-space(text())='Seat type']";
	private String dynamicSeatPriceLocator = "//table[starts-with(@class,'MyTable')]//th[starts-with(text(),'Price')]//following-sibling::td[%d]";
	
	By dynamicBookTicket;
	

	public void clickOnSeatType(String seatType) {
		dynamicBookTicket = By.xpath(String.format(dynamicBookTicketLocator, seatType));
		DriverUtils.driver.findElement(dynamicBookTicket).click();
	}
	
	private int getSeatTypeColumn(String seatType){
//		int maxType = 20;
		int j = 0;
		By seatTypeElement  = By.xpath(String.format(seatTypeTblLocator + "//following-sibling::td"));
		for (int i = 0; i < DriverUtils.driver.findElements(seatTypeElement).size(); i++){
			j = i + 1;
			String columnName = DriverUtils.driver.findElement(By.xpath(String.format(seatTypeTblLocator + "//following-sibling::td[%d]", j))).getText();
			if (columnName.equalsIgnoreCase(seatType)) {
				break;
			}
		}
		return j;
	}
	
	public String getSeatTypePrice(String seatType){
		int seatTypePos = getSeatTypeColumn(seatType);
		By dynamicSeatPrice = By.xpath(String.format(dynamicSeatPriceLocator, seatTypePos));
		System.out.println(dynamicSeatPrice);
		return DriverUtils.driver.findElement(dynamicSeatPrice).getText();
	}

}
