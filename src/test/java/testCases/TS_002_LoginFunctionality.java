package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.BaseClass;
import utilities.XLUtility;

public class TS_002_LoginFunctionality extends BaseClass {



	@Test(dataProvider = "LoginData", groups = {"sanity"})
	public void test_login(String email, String pwd, String exp) throws IOException {

		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccountIcon();
		hp.clickOnLoginLink();

		LoginPage lp = new LoginPage(driver);
//		lp.inputEmail(rb.getString("email"));
		lp.inputEmail(email);
//		lp.inputpassword(rb.getString("password"));
		lp.inputpassword(pwd);
		lp.clickLoginBtn();

		if (exp.equals("Valid")) {

			try {

				lp.checkLogoutLinkPresent();
				lp.logout();
				logger.info("Passed " + exp + " login success");
				Assert.assertTrue(true);
				

			} catch (Exception e) {
				if(lp.checkLoginLinkPresent()) {
					
					logger.info("failed" + exp + "login not working");
					Assert.fail();
				}
			}
		} else if (exp.equals("Invalid")) {

			try {

				lp.checkLoginLinkPresent();
				logger.info("Passed " + exp + " login not success");
				Assert.assertTrue(true);

			} catch (Exception e) {
				if(lp.checkLogoutLinkPresent()) {
					logger.info("FAILED, login was success but expected was: " + exp);
					Assert.fail();
				}
			}

		}


	}

	
	
	
	
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";

		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];
		


		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return logindata;

	}

}
