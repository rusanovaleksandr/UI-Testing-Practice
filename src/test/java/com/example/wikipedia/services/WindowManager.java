package com.example.wikipedia.services;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class WindowManager {
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