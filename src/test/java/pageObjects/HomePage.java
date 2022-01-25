package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this); 
	}

	// locators(pageFacroty)
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount_icon;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerLink;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginLink;

	// Action Methods
	public void clickOnMyAccountIcon() {
		myAccount_icon.click();
	}

	public void clickOnRegisterLink() {
		registerLink.click();
	}

	public void clickOnLoginLink() {
		loginLink.click();
	}
	
	
	

}
