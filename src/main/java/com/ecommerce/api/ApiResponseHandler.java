package com.ecommerce.api;

import io.restassured.response.Response;

public class ApiResponseHandler {

    public static void verifyResponseCode(Response response){
        int statusCode =response.statusCode();
        if(statusCode>=400){
            throw new RuntimeException("Api Call failed with Status Code :" +statusCode +" Response Body: "+response.getBody().asString());
        }


    }

}
