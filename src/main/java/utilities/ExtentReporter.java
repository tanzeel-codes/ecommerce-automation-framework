package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    static ExtentReports extentReport;

    public static ExtentReports getExtentReport() {
        String extentReportPath = System.getProperty("user.dir") + "\\reports\\extentreports.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath); // CREATES HTML FILE
        reporter.config().setReportName("Automation Report"); // TITLE DISPLAYED ON DASHBOARD
        reporter.config().setDocumentTitle("Test Results"); // DOCUMENT TITLE

        extentReport  = new ExtentReports(); // MANAGER THAT COLLECTS ALL RESULT
        extentReport.attachReporter(reporter); // CONNECT REPORTER TO EXTENT
        extentReport.setSystemInfo("OS", "Window 11");
        extentReport.setSystemInfo("Tester", "Tanzeel");

        return extentReport;
    }
}
