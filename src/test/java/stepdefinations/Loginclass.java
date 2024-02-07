package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DevFrame.Base1;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class Loginclass extends Base1 {

	WebDriver driver;
	LoginPage loginpage;
	LandingPage landingpage;

	@Given("^Open any Browser$")
	public void open_Any_Browser() throws IOException {

		driver = InitialiseBrowser();

	}

	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() throws InterruptedException {

		driver.get(prop1.getProperty("url"));
		Thread.sleep(4000);

		landingpage = new LandingPage(driver);

		landingpage.MyAccountDropDown().click();
		landingpage.LoginButton().click();
		Thread.sleep(4000);

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_and_password_as_into_the_fields(String username, String password)
			throws InterruptedException {
		loginpage = new LoginPage(driver);

		loginpage.InputUsername().sendKeys(username);

		loginpage.InputPassword().sendKeys(password);
		Thread.sleep(4000);

	}

	@And("^User clicks on Login button$")
	public void User_clicks_on_Login_button() {

		loginpage = new LoginPage(driver);

		loginpage.SubmitLogin().click();

	}

	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {

		AccountPage accountpage = new AccountPage(driver);

		Assert.assertTrue(accountpage.AccountInformatioPage().isDisplayed());

	}

	@After
	public void closure() {

		driver.close();
	}

}
