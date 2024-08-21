package com.ecommerce.reporting;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PerformanceReportGenerator {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    static {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/performance-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    public static void generatePerformanceReport() {
        extentTest = extentReports.createTest("Performance Test");
        // Add performance metrics
        extentTest.pass("Performance metrics logged");
        extentReports.flush();
    }
}

