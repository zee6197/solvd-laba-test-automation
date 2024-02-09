package com.solvd.laba.web.components;

import com.solvd.laba.web.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id = 'nav-search']//*[@id = 'searchDropdownBox']")
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath = ".//input[@id = 'twotabsearchtextbox']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//*[@id = 'nav-search-submit-button']")
    private ExtendedWebElement searchButton;


    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }


    public void typeSearchInputValue(String value) {
        searchInput.sendKeys(value);
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
