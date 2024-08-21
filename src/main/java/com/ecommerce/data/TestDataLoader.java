package com.ecommerce.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class TestDataLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T loadDataFromJson(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(filePath), clazz);
    }
}
