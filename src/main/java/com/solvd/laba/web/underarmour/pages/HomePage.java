package com.solvd.laba.web.underarmour.pages;

import com.solvd.laba.web.underarmour.components.Header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;


public class HomePage extends AbstractPage {

    private WebDriver driver;
    private Header header;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[2]/a")
    private ExtendedWebElement mensSectionButton;

    @FindBy(xpath = "//a[contains(@class, 'HeaderUtility_header-account-link') and contains(text(), 'Need Help?')]")
    private ExtendedWebElement needHelpButton;

    @FindBy(xpath = ".//a[contains(@class, 'Header_nav-icon-bag')]")
    private ExtendedWebElement shoppingCartIcon;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

        openURL(Configuration.getRequired("ua_url"));
    }

    public MensSectionPage clickOnMensSection() {
        mensSectionButton.click();
        return new MensSectionPage(getDriver());

    }

    public NeedHelpPage clickOnNeedHelp() {
        needHelpButton.click();
        return new NeedHelpPage(getDriver());

    }

    public ShoppingCartPage clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
        return new ShoppingCartPage(driver);
    }

    public String getCurrentURL() {

        return driver.getCurrentUrl();
    }

    public Header getHeader() {

        return header;
    }
}
