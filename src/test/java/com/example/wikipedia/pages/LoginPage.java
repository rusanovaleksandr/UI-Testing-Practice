package com.example.wikipedia.pages;

import com.example.wikipedia.elements.InputElement;
import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.WrongLoginMessage;

/**
 * Класс, представляющий страницу входа в систему.
 * Содержит методы для взаимодействия с элементами страницы
 * и выполнения действий, связанных с авторизацией.
 */
public class LoginPage {
    private final InputElement loginField = InputElement.byName("wpName");
    private final InputElement passwordField = InputElement.byName("wpPassword");
    private final InteractiveElement loginAttemptButton = InteractiveElement.byType("submit");
    private final WrongLoginMessage wrongLoginMessage = WrongLoginMessage.byClass("cdx-message__content");

    /**
     * Вводит логин в поле для ввода логина.
     *
     * @param login строка, представляющая логин пользователя
     * @return текущий экземпляр LoginPage для цепочки вызовов
     */
    public LoginPage enterLogin(String login) {
        loginField.fill(login);
        return this;
    }

    /**
     * Вводит пароль в поле для ввода пароля.
     *
     * @param password строка, представляющая пароль пользователя
     * @return текущий экземпляр LoginPage для цепочки вызовов
     */
    public LoginPage enterPassword(String password) {
        passwordField.fill(password);
        return this;
    }

    /**
     * Отправляет форму входа, нажимая на кнопку входа.
     */
    public void submit() {
        loginAttemptButton.click();
    }

    /**
     * Получает текст сообщения об ошибке входа, если таковое имеется.
     *
     * @return строка, представляющая текст сообщения об ошибке
     */
    public String getErrorMessage() {
        return wrongLoginMessage.getMessageText();
    }
}
