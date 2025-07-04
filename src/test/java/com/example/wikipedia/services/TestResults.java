package com.example.wikipedia.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TestResults {
    private static final String FILE_PATH = "src/test/resources/test-data.json";
    private static Map<String, String> results = new HashMap<>();
    
    public static void addResult(String testName, String articleTitle) {
        results.put(testName, articleTitle);
        saveToFile();
    }
    
    private static void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(results, writer);
        } catch (Exception e) {
            System.err.println("Failed to save test results: " + e.getMessage());
        }
    }
    
    public static void init() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                try (Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
                    results = new Gson().fromJson(
                        reader,
                        new TypeToken<Map<String, String>>(){}.getType()
                    );
                    if (results == null) {
                        results = new HashMap<>();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to load test results: " + e.getMessage());
            results = new HashMap<>();
        }
    }
    
    public static Map<String, String> getResults() {
        return new HashMap<>(results); 
    }
}