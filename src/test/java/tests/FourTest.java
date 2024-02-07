package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import DevFrame.Base1;

public class FourTest extends Base1 {
	
	public WebDriver driver;
	@Test
	public void fourTest() throws IOException, InterruptedException {

		driver = InitialiseBrowser();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		
		Assert.assertTrue(false);
		
	
		
		
	}
	@AfterMethod
	public void closure() {
		
		driver.close();
	}

}