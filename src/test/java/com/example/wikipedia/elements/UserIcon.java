package com.example.wikipedia.elements;

public class UserIcon extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_SELECTOR = "#pt-userpage";

    public UserIcon(String selector, boolean xpath) {
        super(selector, xpath);
    }

   public String getText()
   {
        return element.getText();
   }

   public static UserIcon byId(String id){
        return new UserIcon(String.format(ID_XPATH, id), true);
    }

    public static UserIcon byDefault() {
        return new UserIcon(DEFAULT_SELECTOR, false);
    }
}
