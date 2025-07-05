package com.example.wikipedia.pages;

import com.example.wikipedia.elements.InputElement;
import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.WrongLoginMessage;

public class LoginPage {
    private final InputElement loginField = InputElement.byName("wpName");
    private final InputElement passwordField = InputElement.byName("wpPassword");
    private final InteractiveElement loginAttemptButton = InteractiveElement.byType("submit");
    private final WrongLoginMessage wrongLoginMessage = WrongLoginMessage.byClass("cdx-message__content");

    public LoginPage enterLogin(String login) {
        loginField.fill(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.fill(password);
        return this;
    }

    public void submit() {
        loginAttemptButton.click();
    }

    public String getErrorMessage() {
        return wrongLoginMessage.getMessageText();
    }
}