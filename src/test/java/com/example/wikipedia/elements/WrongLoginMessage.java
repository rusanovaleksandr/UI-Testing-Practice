package com.example.wikipedia.elements;
import static com.codeborne.selenide.Condition.visible;

public class WrongLoginMessage extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = ".cdx-message--error .cdx-message__content";
    
    public WrongLoginMessage(String selector) {
        super(selector);
    }

    public String getMessageText() {
        return element
            .shouldBe(visible) // Ожидаем видимости элемента
            .getText()
            .trim();
    }



    public static WrongLoginMessage byDefault(){
        return new WrongLoginMessage(DEFAULT_CSS_SELECTOR);
    }
}
