package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DevFrame.Base1;

public class TwoTest extends Base1 {
	
	WebDriver driver;
	@Test
	public void twoTest() throws InterruptedException, IOException {
		
		System.out.println("This is Committed by Amol k");

		driver = InitialiseBrowser();
		driver.get("https://www.alibaba.com/");
		Thread.sleep(3000);
		driver.close();
		
	}

}
