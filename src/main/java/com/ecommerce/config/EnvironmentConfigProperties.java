package com.ecommerce.config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfigProperties {
    private static Properties properties = new Properties();
    static{
        try(InputStream inputstream=EnvironmentConfigProperties.class.getResourceAsStream("application.properties")){
            if(inputstream!=null){
                //Properties  properties = new Properties();
                properties.load(inputstream);

            }else{
            throw new FileNotFoundException("application.properties file is not available");}
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return properties.getProperty(key);

    }
}
