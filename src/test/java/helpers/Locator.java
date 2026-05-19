package helpers;

import org.openqa.selenium.By;

public class Locator {
	private By by;
	
	private Locator (By by) {this.by = by;}
	
	public By getBy() {return this.getBy();}
	
	public static Locator xpath(String xpath) {return new Locator(By.xpath(xpath));}
	
	public static Locator dynamicXpath(String xpath, String...args) {
		return new Locator(By.xpath(String.format(xpath, args)));
	}

	public static Locator cssSelector (String css) {return new Locator(By.cssSelector(css)); }
	
	public static Locator id(String id) {return new Locator(By.id(id)); }
	
	public static Locator name(String name) {return new Locator(By.name(name)); }
	
	public static Locator className(String className) {return new Locator(By.className(className)); }
	
	public static Locator linkText(String linkText) {return new Locator(By.linkText(linkText)); }
	
	public static Locator partialLinkText(String partialLinkText) {return new Locator(By.partialLinkText(partialLinkText)); }
	
}
