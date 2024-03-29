package pageobjects;

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

	@FindBy(id = "input-email")
	private WebElement InputUsername;

	@FindBy(id = "input-password")
	private WebElement InputPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement SubmitLogin;

	public WebElement InputUsername() {
		return InputUsername;
	}

	public WebElement InputPassword() {
		return InputPassword;
	}

	public WebElement SubmitLogin() {
		return SubmitLogin;
	}
}
