package com.ecommerce.tests;

import com.ecommerce.model.Category;
import com.ecommerce.listeners.ExtentReportListener;
import com.ecommerce.services.CategoryService;
import com.ecommerce.utils.ReadWriteToPropertiesFile;
import com.ecommerce.validation.ApiValidation;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportListener.class)
public class CategoryTests {
    String strEndPoint ="/ecommerce/categories";
    String token="";
    Response response;
    private static String getAccessKey() {
        return ReadWriteToPropertiesFile.retrieveValueFromPropertiesFile("accessToken");
    }
    @Test
    public void createCategory(){
        try {
            Thread.sleep(10000); // Sleep for 3000 milliseconds (3 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Category category = new Category();
        category.setName("shirts");

        response=CategoryService.createCategory(category,strEndPoint);
        //System.out.println("category response : " + response.getBody().asString());
        //String cookies= response.getCookie("accessToken");
        //String refress= response.getCookie("refreshToken");

        //System.out.println("acces"+cookies);
        //System.out.println(response.getCookies());

        ApiValidation.validateStatusCode(response,201);


    }
    //@Test
    public void categoryTest(){
        String requestBody="{ \"name\": \"shirts\"}";
        Response response=RestAssured.given()
                .baseUri("http://localhost:9090/api/v1/ecommerce/categories")
                .contentType(ContentType.JSON)
                .header("accept","application/json")
                .header("Cookie","accessToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmM0NWU3NGU1OGExNDI2M2M4YmMwNGUiLCJlbWFpbCI6InN1c2Fudy5lbWFpbEBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InN1c2FudyIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTcyNDE0NTI5MCwiZXhwIjoxNzI0MjMxNjkwfQ.EdnSfZSFzwegRuAa3vxaV-8a6BDJkFMyMnaq2vGoYxs")

                .body(requestBody)
                .when()
                .post();

        //System.out.println("response: "+response.getBody().asString());





    }


}
