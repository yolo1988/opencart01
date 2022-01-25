package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TS_001_RegisterFunctionality extends BaseClass {

	@Test(groups= {"smoke"})
	public void testRegister() throws IOException {
		logger.info("Testing Starting");
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccountIcon();
		hp.clickOnRegisterLink();
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		rap.inputFirstName("Jhon");
		rap.inputLastName("Doe");
		rap.inputEmail(generateRandomString(8) + "@gmail.com");
		rap.inputTelephone(generateRandomString(9));
		String pass = generateRandomString(10);
		rap.inputPassword(pass);
		rap.inputPasswordConfirm(pass);
		rap.agreeCheckBoxClick();
		rap.clickContinue();
		logger.info("Everything Finished with " + browserName);

		if(rap.checkSuccessfulInnerText()) {
			Assert.assertTrue(true);

		}else {
			String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
			takeScreenShot(nameofCurrMethod, driver);
			Assert.assertTrue(false);
		}	
//	Assert.assertEquals(rap.checkSuccessfulRegistration(), true);
//	Assert.assertEquals(rap.checkSuccessfulInnerText(), true, "Test Failed");

	}

}
