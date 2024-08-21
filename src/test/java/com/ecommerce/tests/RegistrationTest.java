package com.ecommerce.tests;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.listeners.ExtentReportListener;
import com.ecommerce.model.Registration;
import com.ecommerce.model.UserLogin;
import com.ecommerce.services.RegistrationService;
import com.ecommerce.utils.FileUtil;
import com.ecommerce.utils.JsonUtil;
import com.ecommerce.utils.RandomDataGenerator;
import com.ecommerce.utils.ReadWriteToPropertiesFile;
import com.ecommerce.validation.ApiValidation;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReportListener.class)
public final class RegistrationTest {
    String fileRead = FileUtil.readRequestDataFromFile("src/test/java/com/ecommerce/data/RegistrationDataFile.txt");
    String loginJsonFile= FileUtil.readRequestDataFromFile("src/test/java/com/ecommerce/data/UserJsonData.txt");
    public String registrationEndPoint = "/users/register";
    public String loginEndPoint = "/users/login";
    private Response response;
    String strUserName=RandomDataGenerator.randomFirstName();


    @Test
    public void tc_01_verifyregistrationTest() {
        try {
            Registration registration = new Registration();
            registration.setEmail(strUserName + ".email@gmail.com");
            registration.setPassword("test@123");
            registration.setRoll("1234");
            registration.setUsername(strUserName);
            //System.out.println(registration.toString());
            // ExtentTest test = ExtentReportListener.getExtentReports().createTest("testCreateUser");
            //test.log(Status.LOG, "Starting testCreateUser");
            response = RegistrationService.createUserRegistration(registration, registrationEndPoint);
            System.out.println("response body: " + response.getBody().asString());
            ApiValidation.validateStatusCode(response, 201);
            //test.log(Status.PASS, "Registration is successful");
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

    @Test
    public void tc_02_VerifyUserLogin(){
        UserLogin login = new UserLogin();
        login.setUsername(strUserName);
        login.setPassword("test@123");
        response = RegistrationService.userLogin(login, loginEndPoint);
        System.out.println("response body: " + response.getBody().asString());
        //JSONObject jsonObject = new JSONObject(response);
        //String strAccessToken= response.getBody().jsonPath().getString("data.accessToken");
        String strAccessToken= response.getBody().jsonPath().getString("data.accessToken");
        ReadWriteToPropertiesFile.storeAccessTokenInPropertiesFile(strAccessToken);
        System.out.println("access token: "+strAccessToken);
        ApiValidation.validateStatusCode(response, 200);

    }
}
