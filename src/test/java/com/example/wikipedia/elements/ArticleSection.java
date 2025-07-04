package com.example.wikipedia.elements;

public class ArticleSection extends BaseElement{
    public ArticleSection(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static ArticleSection byId(String id){
        return new ArticleSection(String.format(ID_XPATH, id), true); 
    }
}
