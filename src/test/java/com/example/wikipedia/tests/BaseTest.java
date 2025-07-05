package com.example.wikipedia.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.open;
import com.example.wikipedia.pages.MainPage;
import com.example.wikipedia.services.AuthService;

/**
 * Базовый класс для тестов, содержащий общие настройки и методы,
 * используемые в тестах приложения.
 */
public class BaseTest {
    protected MainPage mainPage; 

    /**
     * Настраивает конфигурацию Selenide перед выполнением всех тестов.
     */
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

    /**
     * Инициализирует состояние перед каждым тестом,
     * открывая главную страницу и выполняя аутентификацию.
     */
    @BeforeEach
    void init() {
        openMainPage();
        auth();
    }

    /**
     * Открывает главную страницу Википедии.
     */
    void openMainPage() {
        open("/wiki/Главная_страница");
        mainPage = new MainPage();
    }

    /**
     * Выполняет аутентификацию пользователя на главной странице.
     */
    void auth() {
        mainPage = AuthService.login(mainPage);
    }
}
