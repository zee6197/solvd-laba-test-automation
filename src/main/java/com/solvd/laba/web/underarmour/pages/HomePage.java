package com.solvd.laba.web.underarmour.pages;

import com.solvd.laba.web.underarmour.components.Header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.config.Configuration;

public class HomePage extends UnderArmourAbstractPage {

    private Header header;


    // TODO: 1st Test Feedback: Good practice to create the whole navigation bar using ENUM and then test the navigation bar using the ENUM!
    // TODO: xpath locator for whole navigation bar: //*[@role='menuitem']/a & use List of ExtendedWebElement!
    @FindBy(xpath = "//*[@id='menu']/li[2]/a")
    private ExtendedWebElement mensSectionButton;

    @FindBy(xpath = "//a[contains(@class, 'HeaderUtility_header-account-link') and contains(text(), 'Need Help?')]")
    private ExtendedWebElement needHelpButton;

    @FindBy(xpath = ".//a[contains(@class, 'Header_nav-icon-bag')]")
    private ExtendedWebElement shoppingCartIcon;

    @FindBy(xpath = "//input[@id='search-input']")
    private ExtendedWebElement searchInput;



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
        return new ShoppingCartPage(getDriver());
    }

    public void enterSearchTermAndSubmit(String searchTerm) {
        searchInput.type(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    public Header getHeader() {

        return header;
    }
}
