package com.example.wikipedia.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.example.wikipedia.pages.MainPage;

public class BaseTest {
    protected final MainPage mainPage = MainPage.byDefault();
    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://ru.wikipedia.org";
        Configuration.headless = false;
    }

    @BeforeEach
    public void openMainPage() {
        mainPage.open(); // Открываем главную страницу перед каждым тестом
    }
}