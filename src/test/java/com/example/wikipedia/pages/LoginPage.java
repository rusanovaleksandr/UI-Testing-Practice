package com.example.wikipedia.pages;

import com.example.wikipedia.elements.LoginAttemptButton;
import com.example.wikipedia.elements.LoginField;
import com.example.wikipedia.elements.PasswordField;
import com.example.wikipedia.elements.WrongLoginMessage;

public class LoginPage {
    private final LoginField loginField = LoginField.byName("wpName");
    private final PasswordField passwordField = PasswordField.byName("wpPassword");
    private final LoginAttemptButton loginAttemptButton = LoginAttemptButton.byType("submit");
    private final WrongLoginMessage wrongLoginMessage = WrongLoginMessage.byClass("cdx-message__content");

    public LoginPage enterLogin(String login) {
        loginField.setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public void submit() {
        loginAttemptButton.click();
    }

    public String getErrorMessage() {
        return wrongLoginMessage.getMessageText();
    }
}