package com.ecommerce.data;


import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        // Return test data as 2D array
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"}
        };
    }
}

