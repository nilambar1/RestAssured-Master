package com.ecommerce.tests;

import com.ecommerce.listeners.ExtentReportListener;
import com.ecommerce.services.ProductsService;
import com.ecommerce.validation.ApiValidation;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReportListener.class)
public class ProductTests {
    Response response;
   // @Test
    public void TC_01_createProduct(){
        response=ProductsService.createProduct("/ecommerce/products");
        System.out.println("create porduct response:  " +response.getBody().asString());
        ApiValidation.validateStatusCode(response, 201);

    }

    @Test
    public void TC_02_getAllProduct(){
        response =ProductsService.getAllProducts("/ecommerce/products?page=1&limit=10");
        System.out.println("product response" + response.getBody().asString());
        ApiValidation.validateStatusCode(response,200);
        }

   // @Test
    public void TC_03_deleteProduct(){
        response=ProductsService.deleteProduct("/ecommerce/products");
        ApiValidation.validateStatusCode(response,200);
    }






}
