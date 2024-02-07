package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DevFrame.Base1;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LoginTest extends Base1 {
	public WebDriver driver;
	public Logger log;

	@Test(dataProvider = "getlogindata")
	public void login(String username, String password, String ExpectedResult) throws IOException {

		LandingPage landingpage = new LandingPage(driver);

		landingpage.MyAccountDropDown().click();
		landingpage.LoginButton().click();

		LoginPage loginpage = new LoginPage(driver);
		log.debug("Username entered");
		loginpage.InputUsername().sendKeys(username);
		log.debug("Password entered");
		loginpage.InputPassword().sendKeys(password);
		log.debug("login button click ");
		loginpage.SubmitLogin().click();

		AccountPage accountpage = new AccountPage(driver);

		String Expected = null;
		try {

			if (accountpage.AccountInformatioPage().isDisplayed()) {
				Expected = "Successfull";
				log.debug("Test is Successful");
			}

		} catch (Exception e) {

			Expected = "Failure";
			log.debug("Method get failed");
		}

		Assert.assertEquals(Expected, ExpectedResult);

	}

	@BeforeMethod
	public void openApplication() throws IOException {

		log = LogManager.getLogger(LoginTest.class.getName());

		driver = InitialiseBrowser();
		log.debug("Chrome Browser got launched");
		driver.get(prop1.getProperty("url"));
		log.debug("Application got opened");
	}

	@AfterMethod
	public void closure() {

		driver.close();
		log.debug("Browser getting close");
	}

	@DataProvider
	public Object[][] getlogindata() {

		Object[][] data = { { "infosys@gmail.com", "Infosys@123", "Successfull" } };
		return data;
	}

}
