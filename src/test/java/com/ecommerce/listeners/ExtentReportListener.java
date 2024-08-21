package com.ecommerce.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecommerce.utils.LoggerUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    static {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        LoggerUtil.logInfo("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test passed");
        LoggerUtil.logInfo("Test passed: " + result.getMethod().getMethodName());

        if (result.getTestContext().getAttribute("response") != null) {
            String responseData = (String) result.getTestContext().getAttribute("response");
            extentTest.log(Status.INFO, "Response: " + responseData);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail(result.getThrowable());
        LoggerUtil.logError("Test failed: " + result.getMethod().getMethodName(), result.getThrowable());
        // Log the response data
        if (result.getTestContext().getAttribute("response") != null) {
            String responseData = (String) result.getTestContext().getAttribute("response");
            extentTest.log(Status.INFO, "Response: " + responseData);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip("Test skipped");
        LoggerUtil.logInfo("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test method is run
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        LoggerUtil.logInfo("Extent report generated.");
    }
}
