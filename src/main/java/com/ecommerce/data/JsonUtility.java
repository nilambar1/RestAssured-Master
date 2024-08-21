package com.ecommerce.data;


import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtility {

    private String filePath;

    public JsonUtility(String filePath) {
        this.filePath = filePath;
    }

    // Method to read data from a JSON file
    public JSONObject readJsonFile() {
        JSONObject jsonObject = null;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            jsonObject = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    // Method to write data to a JSON file
    public void writeJsonFile(JSONObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonObject.toString(4)); // Pretty print with an indent factor of 4
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update a value in the JSON file
    public void updateJsonValue(String key, Object value) {
        JSONObject jsonObject = readJsonFile();
        if (jsonObject != null) {
            jsonObject.put(key, value);
            writeJsonFile(jsonObject);
        }
    }
}

