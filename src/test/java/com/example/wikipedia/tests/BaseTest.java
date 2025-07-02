package com.example.wikipedia.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.example.wikipedia.pages.MainPage;
import com.example.wikipedia.services.AuthService;

public class BaseTest {
    protected MainPage mainPage; 

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://ru.wikipedia.org";
        Configuration.headless = false;
    }

    @BeforeEach
    void auth() {
        mainPage = AuthService.login();// Авторизация перед каждым тестом
    }
}