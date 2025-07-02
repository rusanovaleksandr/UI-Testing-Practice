package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import com.example.wikipedia.pages.MainPage;

import io.github.cdimascio.dotenv.Dotenv;

import com.example.wikipedia.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class InvalidLoginTest extends BaseTest {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String LOGIN = dotenv.get("WIKIPEDIA_LOGIN");
    private static final String INVALID_LOGIN = dotenv.get("INVALID_LOGIN");
    private static final String INVALID_PASSWORD = dotenv.get("INVALID_PASSWORD");

    @BeforeEach
    @Override
    void auth() {
        // Переопределяем метод, чтобы авторизация не выполнялась
        mainPage = MainPage.byDefault();
        mainPage.open();

        // Если пользователь авторизован — выходим
        if (mainPage.isLoggedIn(LOGIN)) {
            mainPage.logout();
        }
    }

    @Test
    void shouldShowErrorOnInvalidCredentials() {
        LoginPage loginPage = mainPage.clickLoginButton();
        
        loginPage
            .enterLogin(INVALID_LOGIN)
            .enterPassword(INVALID_PASSWORD);
        loginPage.submit();
        String errorMessage = loginPage.getErrorMessage();
        assertEquals("Введены неверные имя участника или пароль. Попробуйте ещё раз.", errorMessage);
    }
}