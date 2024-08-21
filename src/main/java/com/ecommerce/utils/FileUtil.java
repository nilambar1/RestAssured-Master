package com.ecommerce.utils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String registrationFileBody;

    public static String readFileAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    public static String readRequestDataFromFile(String filePath){
        try{
            return registrationFileBody = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("The file is not available in location");

        }
    }
}

