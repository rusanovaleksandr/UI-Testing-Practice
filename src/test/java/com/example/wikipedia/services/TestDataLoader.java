package com.example.wikipedia.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

/**
 * Класс для загрузки тестовых данных из JSON-файла.
 * Содержит методы для доступа к тестовым данным, используемым в тестах.
 */
public class TestDataLoader {
    private static final String TEST_DATA_PATH = "src/test/resources/tcst-data.json";
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

    /**
     * Получает тестовую статью по указанному ключу.
     *
     * @param key строка, представляющая ключ для доступа к тестовой статье
     * @return строка, представляющая тестовую статью, или null, если ключ не найден
     */
    public static String getTestArticle(String key) {
        return testData.get(key);
    }
}
