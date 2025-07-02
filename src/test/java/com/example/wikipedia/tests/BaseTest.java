package com.example.wikipedia.tests;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://ru.wikipedia.org";
        Configuration.headless = false;
    }
}