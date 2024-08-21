package com.ecommerce.hooks;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestHooks {
    @BeforeClass
    public void setUp() {
        // Initialize resources, e.g., setting up database connections or API clients
    }

    @AfterClass
    public void tearDown() {
        // Clean up resources, e.g., closing connections or deleting test data
    }
}

