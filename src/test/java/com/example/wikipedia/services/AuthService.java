package com.example.wikipedia.services;

import com.example.wikipedia.pages.LoginPage;
import com.example.wikipedia.pages.MainPage;

import io.github.cdimascio.dotenv.Dotenv;

public class AuthService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String LOGIN = dotenv.get("WIKIPEDIA_LOGIN");

    public static MainPage login(MainPage mainPage) {
        // Если уже авторизованы, пропускаем вход
        if (mainPage.isLoggedIn(LOGIN)) {
            return mainPage;
        }
        
        // Если нет — выполняем вход
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.enterLogin(LOGIN)
                .enterPassword(dotenv.get("WIKIPEDIA_PASSWORD"))
                .submit();
        
        return mainPage;
    }
}