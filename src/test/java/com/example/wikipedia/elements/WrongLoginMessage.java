package com.example.wikipedia.elements;
import static com.codeborne.selenide.Condition.visible;

public class WrongLoginMessage extends BaseElement {
    private static final String CLASS_XPATH = "//*[@class='%s']";
    private static final String DEFAULT_CSS_SELECTOR = ".cdx-message--error .cdx-message__content";
    
    public WrongLoginMessage(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public String getMessageText() {
        return element
            .shouldBe(visible) 
            .getText()
            .trim();
    }

    public static WrongLoginMessage byClass(String class_name){
        return new WrongLoginMessage(String.format(CLASS_XPATH, class_name), true);
    }

    public static WrongLoginMessage byDefault(){
        return new WrongLoginMessage(DEFAULT_CSS_SELECTOR, false);
    }
}
