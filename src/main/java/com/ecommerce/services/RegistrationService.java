package com.ecommerce.services;

import com.ecommerce.api.ApiClient;

import io.restassured.response.Response;

public class RegistrationService {
      private static Response response;


    public  static Response  createUserRegistration(Object registration, String endPoint ){
        System.out.println(registration.toString());
       return response =ApiClient.post(registration,endPoint);

    }
    public static Response userLogin(Object login,  String endPoint){
        return response =ApiClient.post(login,endPoint);
    }

}
