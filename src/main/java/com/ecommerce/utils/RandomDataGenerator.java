package com.ecommerce.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {
    private static Faker faker = new Faker();
    public static String randomFirstName(){
        return faker.name().firstName().toLowerCase();
    }
    public static String randomLastName(){
        return faker.name().lastName();
    }
    public static String randomFullName(){
        return faker.name().fullName();
    }
    public static String randomEmail(){
        return faker.internet().emailAddress();
    }


}
