package pageobjects;

import org.openqa.selenium.By;


import helpers.ElementsUtils;

public class TimeTablePage extends BasePage{

	
	String dynamicCheckPrice = "//tr[td[text()='%s']//following-sibling::td[text()='%s']]//td/a[text()='check price']";
	String dynamicBookTicket = "//tr[td[text()='%s']//following-sibling::td[text()='%s']]//td/a[text()='book ticket']";
	
	By dynamicCheckPriceButton;
	
	public void clikcOnCheckPrice(String departStation, String arriveStation) {
		dynamicCheckPriceButton = By.xpath(String.format(dynamicCheckPrice, departStation, arriveStation));
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(dynamicCheckPriceButton));
		ElementsUtils.scrollIntoView(ElementsUtils.findElement(dynamicCheckPriceButton));
		ElementsUtils.findElement(dynamicCheckPriceButton).click();
	}
	public void clikcOnBookTicket(String departStation, String arriveStation) {
		By dynamicBookTicketButton = By.xpath(String.format(dynamicBookTicket, departStation, arriveStation));
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(dynamicBookTicketButton));
		ElementsUtils.scrollIntoView(ElementsUtils.findElement(dynamicBookTicketButton));
		ElementsUtils.findElement(dynamicBookTicketButton).click();
	}
}
