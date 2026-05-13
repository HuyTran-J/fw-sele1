package pageobjects.thirdPartySite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import helpers.Constant;
import helpers.ElementsUtils;
import helpers.Timer;

public class MailBoxPage  {
	
		private String userBtnLocator = "//div[@id='guerrilla_mail']//span[@id='inbox-id']";
	    private String userInputTxtLocator = "//div[@id='guerrilla_mail']//span[@id='inbox-id']/input";
	    private String setUserEmailBtnLocator = "//div[@id='guerrilla_mail']//span[@id='inbox-id']/button[text()='Set']";
	    private String domainDdlLocator = "//select[@id='gm-host-select']";
	    private String dynamicExpectedEmailLocator = "//tbody[@id='email_list']//tr[contains(@class,email_unread)]//td[contains(text(),'%s')]";
	    private String activateLnkLocator = "//div[@class='email_body']//a";
	    private String emailTokenLblLocator = "//div[@class='email_body']";
	    private String alertLocator="//div[@class='status_alert shadow']";
	    
	    By userBtn = By.xpath(userBtnLocator);
	    By userInputTxt = By.xpath(userInputTxtLocator);
	    By setUserEmailBtn = By.xpath(setUserEmailBtnLocator);
	    By dynamicExpectedEmail;
	    By activateLnk = By.xpath(activateLnkLocator);
	    By emailTokenLbl = By.xpath(emailTokenLblLocator);
	    By alertMssg = By.xpath(alertLocator);
	    
	    public void setEmailUserName(String userName){
	    	ElementsUtils.waitForElementExists(userBtn,Constant.PAGE_WAIT_TIMEOUT);
	    	ElementsUtils.findElement(userBtn).click();
	    	ElementsUtils.waitForElementExists(userInputTxt,Constant.PAGE_WAIT_TIMEOUT);
	    	ElementsUtils.findElement(userInputTxt).clear();
	    	ElementsUtils.findElement(userInputTxt).sendKeys(userName);
	    	ElementsUtils.waitForElementExists(setUserEmailBtn,Constant.PAGE_WAIT_TIMEOUT);
	        ElementsUtils.findElement(setUserEmailBtn).click();
	    }
	    public void selectEmailDomain(String emailDomain){
	        Select domainDdl = new Select(ElementsUtils.findElement(By.xpath(domainDdlLocator)));
	        domainDdl.selectByVisibleText(emailDomain);
	    }
	    
	    public void selectExpectedEmail(String emailTitle){
	        dynamicExpectedEmail = By.xpath(String.format(dynamicExpectedEmailLocator, emailTitle));
	        ElementsUtils.waitForElementExists(dynamicExpectedEmail,Constant.PAGE_WAIT_TIMEOUT);
	        ElementsUtils.findElement(dynamicExpectedEmail).click();
	    }
	    public void clickActivateAcount() {
	    	ElementsUtils.waitForElementExists(activateLnk,Constant.PAGE_WAIT_TIMEOUT);
	    	ElementsUtils.scrollIntoView(ElementsUtils.findElement(activateLnk));
	    	Timer.sleep(4500);
	    	ElementsUtils.findElement(activateLnk).click();
	    	Timer.sleep(3000);
        
	    }
	    public String getEmailContent(){
	    	ElementsUtils.waitForElementExists(emailTokenLbl,Constant.PAGE_WAIT_TIMEOUT);
	    	ElementsUtils.findElement(emailTokenLbl).getText();
	        return ElementsUtils.findElement(emailTokenLbl).getText();
	    }
	    public String getConfirmationCode(){
	        String[] emailContent = getEmailContent().split("Your confirmation code is: ");
	        int endPos = emailContent[1].indexOf(". Visit");
	        return emailContent[1].substring(0, endPos);
	    }

}
