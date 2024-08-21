package com.ecommerce.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteToPropertiesFile {
    private static Properties properties = new Properties();
    public static void storeAccessTokenInPropertiesFile(String accessToken) {

        try (FileOutputStream output = new FileOutputStream("src/main/resources/config.properties")) {
            properties.setProperty("accessToken", accessToken);
            properties.store(output, "Access Token");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String retrieveValueFromPropertiesFile(String key){
         String propertiesValue = properties.getProperty(key);
         return propertiesValue;
    }
}
