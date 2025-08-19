package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import utilities.ExtentReporter;


public class Listeners extends Base implements ITestListener {
    private static final Logger logs = LogManager.getLogger(Listeners.class);
    ExtentReports extentReport = ExtentReporter.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        extentTest = extentReport.createTest(testName);
        testThread.set(extentTest);  // NOW THE EXTENT REPORT IS THREAD SAFE
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        /*extentTest.log(Status.PASS, testName+ " got Passed");
        extentTest.pass("Test Passed"); // OR*/

        testThread.get().log(Status.PASS, testName+" got Passed"); // THREAD SAFE
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        testThread.get().fail(result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = Base.driver;
        String screenShotPath = takeScreenshot(testName, driver);
        testThread.get().addScreenCaptureFromPath(screenShotPath, testName);

//        extentTest.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
        logs.info("Takes ScreenShot on Failure");
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
