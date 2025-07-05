package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.LoginPage;

import io.github.cdimascio.dotenv.Dotenv;

public class InvalidLoginTest extends BaseTest {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String LOGIN = dotenv.get("WIKIPEDIA_LOGIN");
    private static final String INVALID_LOGIN = dotenv.get("INVALID_LOGIN");
    private static final String INVALID_PASSWORD = dotenv.get("INVALID_PASSWORD");

    @BeforeEach
    @Override
    void init() {
        openMainPage();
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