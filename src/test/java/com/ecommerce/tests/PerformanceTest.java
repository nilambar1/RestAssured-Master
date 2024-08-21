package com.ecommerce.tests;


import com.ecommerce.reporting.PerformanceReportGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PerformanceTest {
    @Test
    public void testPerformance() {
        long startTime = System.currentTimeMillis();
        Response response = RestAssured.get("url to be added");
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        // Log performance metrics -- the below code shoud be written
       // PerformanceReportGenerator.generatePerformanceReport();

        //assertTrue(responseTime < 2000, "Response time is too high");
    }

    // Additional performance tests
}

