package com.example.wikipedia.elements;

public class UserIcon extends BaseElement {
    private static final String DEFAULT_SELECTOR = "#pt-userpage";

    public UserIcon(String selector) {
        super(selector);
    }

   public String getText()
   {
        return element.getText();
   }

    public static UserIcon byDefault() {
        return new UserIcon(DEFAULT_SELECTOR);
    }
}
