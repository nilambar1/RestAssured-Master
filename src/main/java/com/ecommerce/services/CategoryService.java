package com.ecommerce.services;

import com.ecommerce.api.ApiClient;
import com.ecommerce.model.Category;
import io.restassured.response.Response;

public class CategoryService {
    static Response response;
    public static Response createCategory(Object category, String strEndPoint) {
        return response = ApiClient.postWithToken(category,strEndPoint);


    }
}
