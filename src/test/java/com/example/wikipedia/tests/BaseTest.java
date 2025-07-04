package com.example.wikipedia.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.example.wikipedia.pages.MainPage;
import com.example.wikipedia.services.AuthService;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;

public class BaseTest {
    protected MainPage mainPage; 

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://ru.wikipedia.org";
        Configuration.headless = false;

        Configuration.fileDownload = FOLDER;
        Configuration.proxyEnabled = false;
        Configuration.downloadsFolder = "target/downloads";
    }

    @BeforeEach
    void auth() {
        mainPage = AuthService.login();
    }
}