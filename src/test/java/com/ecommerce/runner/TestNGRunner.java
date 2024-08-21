package com.ecommerce.runner;

import com.ecommerce.tests.CategoryTests;
import com.ecommerce.tests.ProductTests;
import com.ecommerce.tests.ProfileTests;
import com.ecommerce.tests.RegistrationTest;
import org.testng.TestNG;

    public class TestNGRunner {
        public static void main(String[] args) {
            TestNG testNG = new TestNG();
            testNG.setTestClasses(new Class[] { RegistrationTest.class, ProductTests.class, CategoryTests.class, ProfileTests.class});
            testNG.run();
        }
    }


