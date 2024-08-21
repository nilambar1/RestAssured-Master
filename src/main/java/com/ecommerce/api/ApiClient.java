package com.ecommerce.api;

import com.ecommerce.config.Config;
import com.ecommerce.utils.ReadWriteToPropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.sql.SQLOutput;


public class ApiClient {
    // String accessKey=ReadWriteToPropertiesFile.retrieveValueFromPropertiesFile("accessToken");
    static String key ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmM0NWU3NGU1OGExNDI2M2M4YmMwNGUiLCJlbWFpbCI6InN1c2Fudy5lbWFpbEBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InN1c2FudyIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTcyNDE1MDQxNiwiZXhwIjoxNzI0MjM2ODE2fQ.smk6G2QBWAe_Oou8ccgQyxeyAbmXTvtNDSdyZ_pwq0E";

    private static String getBaseUrl() {
        return Config.BASE_URL;
    }

    private static String getAccessKey() {
        return ReadWriteToPropertiesFile.retrieveValueFromPropertiesFile("accessToken");
    }

    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static Response get(String endPoint) {
       // System.out.println(getAccessKey());
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .header("Authorization", "Bearer " + getAccessKey())
                .when()
                .get(endPoint);
    }

    public static Response post(String requestBody, String endPoint) {
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endPoint);

    }

    public static Response postWithFormData(String endPoint) {
        File imageFile1 = new File("src/test/java/com/ecommerce/data/image1.jpeg");
        File imageFile2 = new File("src/test/java/com/ecommerce/data/image2.jpeg");
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .multiPart("category","66bc398868d549cf4a4a3f4e")
                .multiPart("description","New description number 2")
                .multiPart("name","shirt")
                .multiPart("price",230)
                .multiPart("stock", 30)
                .multiPart("mainImage",imageFile1)
                .multiPart("subImages",imageFile2)
                .header("Cookie", "accessToken=" + key)
                .when()
                .post(endPoint);

    }

    public static Response post(Object requestBody, String endPoint) {
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endPoint);

    }

    public static Response postWithToken(Object requestBody, String endPoint) {
       // System.out.println("accesstoken: " + "accessToken=" + getAccessKey());
        //  String key = getAccessKey();
       // System.out.println(getAccessKey());

        return RestAssured.given()
              //  .header("Cookie", "accessToken=" + getAccessKey())
                .baseUri(getBaseUrl())
                .contentType(ContentType.JSON)
              //  .cookie("accessToken"+getAccessKey())
                .header("accept", "application/json")
             //  .header("Cookie","accessToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmM0NWU3NGU1OGExNDI2M2M4YmMwNGUiLCJlbWFpbCI6InN1c2Fudy5lbWFpbEBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InN1c2FudyIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTcyNDE0NTI5MCwiZXhwIjoxNzI0MjMxNjkwfQ.EdnSfZSFzwegRuAa3vxaV-8a6BDJkFMyMnaq2vGoYxs")
                //.header("Authorization","Bearer "+getAccessKey())
                .header("Cookie", "accessToken=" + key)
                .body(requestBody)
                .when()
                .post(endPoint);

    }

    public static Response postWithAccessToken(Object requestBody, String endPoint, String accessToken) {
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .contentType("application/json")
                .header("Authorization", "Bearer " + getAccessKey())
                .body(requestBody)
                .when()
                .post(endPoint);


    }

    public static Response put(String endpoint, Object body) {
        System.out.println(body.toString());
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .contentType("application/json")
                .header("Authorization", "Bearer " + getAccessKey())//can be used the method getAPIKey() to rmove the argument
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response delete(String endpoint) {
        return RestAssured.given()
                .baseUri(getBaseUrl())
             //   .header("Authorization", "Bearer " + getAccessKey())
                .header("Cookie", "accessToken=" + key)
                .when()
                .delete(endpoint);
    }

    public static Response patch(String endpoint, Object body) {
        System.out.println(body.toString());
        return RestAssured.given()
                .baseUri(getBaseUrl())
                .contentType("application/json")
                .header("Authorization", "Bearer " + getAccessKey())//can be used the method getAPIKey() to rmove the argument
                .body(body)
                .when()
                .patch(endpoint);
    }


}
