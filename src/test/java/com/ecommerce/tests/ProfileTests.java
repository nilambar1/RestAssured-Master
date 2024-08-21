package com.ecommerce.tests;

import com.ecommerce.listeners.ExtentReportListener;
import com.ecommerce.model.Profiles;
import com.ecommerce.services.ProfileService;
import com.ecommerce.utils.RandomDataGenerator;
import com.ecommerce.validation.ApiValidation;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestContext;
@Listeners(ExtentReportListener.class)
public class ProfileTests {
    Response response;
    @Test
    public void getProfileData(){
        response = ProfileService.getProfile("/ecommerce/profile");
        //System.out.println(response.getBody().asString());
        ApiValidation.validateStatusCode(response, 200);

    }
    @Test
    public void updateProfileData(){
        Profiles profile = new Profiles();
        profile.setCountryCode("+91");
        profile.setFirstName(RandomDataGenerator.randomFirstName());
        profile.setLastName(RandomDataGenerator.randomLastName());
        profile.setPhoneNumber("9910233990");
        response=ProfileService.updateProfile("/ecommerce/profile",profile);
       // System.out.println("profioleresponse body :  "+response.getBody().asString());
        ApiValidation.validateStatusCode(response,200);

    }
}
