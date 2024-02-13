package com.solvd.laba.web.amazon.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(id = "nav-search")
    private SearchLineComponent searchLineComponent;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }
}
