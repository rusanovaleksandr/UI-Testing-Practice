package com.example.wikipedia.services;

import com.example.wikipedia.pages.LoginPage;
import com.example.wikipedia.pages.MainPage;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Сервис для аутентификации пользователей в приложении.
 * Содержит методы для выполнения входа в систему с использованием
 * учетных данных, загруженных из переменных окружения.
 */
public class AuthService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String LOGIN = dotenv.get("WIKIPEDIA_LOGIN");

    /**
     * Выполняет вход в систему на главной странице.
     * Если пользователь уже авторизован, возвращает текущую главную страницу.
     *
     * @param mainPage экземпляр MainPage, на которой выполняется вход
     * @return экземпляр MainPage после выполнения входа
     */
    public static MainPage login(MainPage mainPage) {
        if (mainPage.isLoggedIn(LOGIN)) {
            return mainPage;
        }
        
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.enterLogin(LOGIN)
                .enterPassword(dotenv.get("WIKIPEDIA_PASSWORD"))
                .submit();
        
        return mainPage;
    }
}
