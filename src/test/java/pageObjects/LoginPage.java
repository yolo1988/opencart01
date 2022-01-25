package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//locators
	
	
	@FindBy(xpath="//input[@id='input-email']") WebElement emailAddressField; 
	
	@FindBy(xpath="//input[@id='input-password']") WebElement passwordField; 
	
	@FindBy(xpath="//input[@value='Login']") WebElement logingBtn; 
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") WebElement loginLink;
	
	//Action methods
	
	
	public void inputEmail(String email) {
		emailAddressField.sendKeys(email);
	}
	
	
	public void inputpassword(String pass) {
		passwordField.sendKeys(pass);
	}
	
	
	public void clickLoginBtn() {
		logingBtn.click();
	}

	public boolean checkLogoutLinkPresent() {
		return logoutLink.isDisplayed();
	}
	
	public void logout() {
		logoutLink.click();
	}
	
	public boolean checkLoginLinkPresent() {
		return loginLink.isDisplayed();
	}
}
