package com.solvd.laba.web.underarmour.components;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header {

    private static WebDriver driver;

    @FindBy(xpath = ".//img[@alt='Under Armour Logo' and contains(@class, 'logo')]")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//nav[contains(@class,'nav')]")
    private ExtendedWebElement primaryNavBar;

    @FindBy(xpath = ".//button[contains(@class, 'HeaderUtility_header-account-link') and contains(text(), 'Log In')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = ".//input[@id='search-input']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = ".//a[contains(@class, 'Header_nav-icon-bag')]")
    private ExtendedWebElement shoppingCartIcon;


    public Header(WebDriver driver) {

        super();
    }

    public void clickOnLogo() {
        logo.click();
    }

    public void clickOnSignIn() {
        loginButton.click();
    }

    public void clickOnShoppingCart() {

        shoppingCartIcon.click();
    }

}
