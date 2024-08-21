package com.ecommerce.services;

import com.ecommerce.api.ApiClient;
import io.restassured.response.Response;

public class ProfileService {
    private static Response response;
    public static Response getProfile(String endPoint) {
       return response=ApiClient.get(endPoint);
    }

    public static Response updateProfile(String endPoint,Object profileBody) {
        return response=ApiClient.patch(endPoint,profileBody);
    }
}
