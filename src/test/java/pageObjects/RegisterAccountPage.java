package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	WebDriver driver;
	
	
	
	
	
	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	// Element Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement passwordConfirm;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement agreeCheckBox;
	
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement continueBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement accSuccessMsg;
	
	// Action Methods
	public void inputFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void inputTelephone(String telephone) {
		this.telephone.sendKeys(telephone);
	}
	
	
	public void inputEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void inputPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm.sendKeys(passwordConfirm);
	}
	
	
	public void agreeCheckBoxClick() {
		agreeCheckBox.click();
	}
	
	
	public void clickContinue() {
		continueBtn.click();
	}
	
	
//	public boolean checkSuccessfulRegistration() {
//		return accSuccessMsg.isDisplayed();
//	}
	
	public boolean checkSuccessfulInnerText() {
		return "Your Account Has Been Created!".equals(accSuccessMsg.getText());
	}

	
	
}
