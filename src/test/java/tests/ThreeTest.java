package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DevFrame.Base1;

public class ThreeTest extends Base1 {
	WebDriver driver;
	@Test
	public void threeTest() throws IOException, InterruptedException {

		driver = InitialiseBrowser();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.close();
		
	}

}