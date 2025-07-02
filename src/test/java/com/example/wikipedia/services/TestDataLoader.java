package com.example.wikipedia.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class TestDataLoader {
    private static final String TEST_DATA_PATH = "src/test/resources/test-data.json";
    private static Map<String, String> testData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            testData = mapper.readValue(new File(TEST_DATA_PATH), 
                new com.fasterxml.jackson.core.type.TypeReference<Map<String, String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    public static String getTestArticle(String key) {
        return testData.get(key);
    }
}