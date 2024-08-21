package com.ecommerce.validation;



import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiValidation {
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code mismatch");
    }

    public static void validateResponseBodyContains(Response response, String expectedContent) {
        Assert.assertTrue(response.getBody().asString().contains(expectedContent), "Response body does not contain expected content");
    }

    public static void validateJsonSchema(Response response, String schemaPath) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
    }
}

