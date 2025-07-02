package com.example.wikipedia.services;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.switchTo;

public class WindowManager {
    public void openInNewTab(String url) {
        executeJavaScript("window.open(arguments[0])", url);
    }

    public void switchToTab(int index) {
        switchTo().window(index);
    }

    public void closeCurrentTab() {
        closeWindow();
    }

    public void scrollToFooter(){
        executeJavaScript("""
            const langBlock = document.querySelector('#p-lang, .interlanguage-list');
            if (langBlock) {
                langBlock.scrollIntoView({behavior: 'smooth', block: 'end'});
            } else {
                window.scrollTo(0, document.body.scrollHeight);
            }
            """);
    }
}
