package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import DevFrame.Base1;
import utilities.Extentreporter;

public class Listeners extends Base1 implements ITestListener {

	ExtentTest extentTest;
	WebDriver driver = null;
	ExtentReports extentReport = Extentreporter.getExtentReport();
	ThreadLocal<ExtentTest> extendThreadTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();

		extentTest = extentReport.createTest(testname);
		extendThreadTest.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname = result.getName();

		// extentTest.log(Status.PASS, testname + "got passed");

		extendThreadTest.get().log(Status.PASS, testname + "got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// extentTest.fail(result.getThrowable());
		extendThreadTest.get().fail(result.getThrowable());

		driver = null;

		String testMethodName = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String screenshotFilePath = takeScreenshot(testMethodName, driver);
			extendThreadTest.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}