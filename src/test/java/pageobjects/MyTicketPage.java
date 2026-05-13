package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import helpers.Constant;
import helpers.DriverUtils;
import helpers.ElementsUtils;
import helpers.Timer;

public class MyTicketPage extends BasePage{
	
	 
		private String notificationLblLocator = "//div[@id='content']//h1";
	    private String ticketInfoTblLocator = "//table[starts-with(@class,'MyTable')]";
	    private String departDateTxtLocator = "//input[@name='FilterDpDate']";
	    private String applyFilterBtnLocator = "//input[@value='Apply filter']";

	    private By notificationLbl;
	    private By departDateTxt;
	    private By applyFilterBtn;
	    
	    public MyTicketPage() 
		{
			pageTitle = "Safe Railway - My Ticket";	
			notificationLbl = By.xpath(notificationLblLocator);
		    departDateTxt = By.xpath(departDateTxtLocator);
		    applyFilterBtn = By.xpath(applyFilterBtnLocator);
		}
	    
	    public String getSuccessPageNotication(){
	        ElementsUtils.waitForElementExists(notificationLbl, Constant.PAGE_WAIT_TIMEOUT);
	        return ElementsUtils.findElement(notificationLbl).getText();
	    }
	    
	    public void cancelTicket(String[] info){
	        String contentRow = String.format(ticketInfoTblLocator + "//tr");
	        String contentXpath = contentRow;
	        for (int i=0; i < info.length; i++){
	            String dynamicContent = "//td[text()=\"%s\"]";
	            if (i>0){
	                dynamicContent = "//following-sibling::td[text()=\"%s\"]";
	            }
	            contentXpath = String.format(contentXpath + dynamicContent, info[i]);
	        }
	        By cancelBtn = By.xpath(String.format(contentXpath + "//following-sibling::td//input[@value='Cancel']"));
	        ElementsUtils.waitForElementExists(cancelBtn,Constant.PAGE_WAIT_TIMEOUT);
	        ElementsUtils.findElement(cancelBtn).click();
	        Timer.sleep(1000);
	        Alert alert = DriverUtils.driver.switchTo().alert();
	        alert.accept();
	    }
	    
	    public boolean isTicketDisplayedOnTable(String[] info){
	        String contentRow = String.format(ticketInfoTblLocator + "//tr");
	        String contentXpath = contentRow;
	        for (int i=0; i < info.length; i++){
	            String dynamicContent = "//td[text()=\"%s\"]";
	            if (i>0){
	                dynamicContent = "//following-sibling::td[text()=\"%s\"]";
	            }
	            contentXpath = String.format(contentXpath + dynamicContent, info[i]);
	        }
	        return ElementsUtils.findElement(By.xpath(contentXpath)).isDisplayed();
	    }
	    
	    public void inputDepartDateFilter(String dateValue){
	        ElementsUtils.findElement(departDateTxt).sendKeys(dateValue);
	    }

	    public void clickApplyFilterButton(){
	        ElementsUtils.waitForElementExists(applyFilterBtn,Constant.PAGE_WAIT_TIMEOUT);
	        ElementsUtils.findElement(applyFilterBtn).click();
	    }
}
