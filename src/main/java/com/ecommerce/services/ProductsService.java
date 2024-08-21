package com.ecommerce.services;

import com.ecommerce.api.ApiClient;
import io.restassured.response.Response;

public class ProductsService {
    static Response response;

    public static Response getAllProducts(String endPoint){
        return response= ApiClient.get(endPoint);

    }

    public static Response deleteProduct(String s) {
        return response=ApiClient.delete(s);
    }

    public static Response createProduct(String s) {
        return response=ApiClient.postWithFormData(s);
    }

    public void createProductwithInvalidData(){

    }



}
