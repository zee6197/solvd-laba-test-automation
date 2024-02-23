package com.solvd.laba.web.underarmour.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class ShoppingCartPage extends UnderArmourAbstractPage {

    @FindBy(xpath = "//button[contains(@class, 'Dialog_close-button')]")
    private ExtendedWebElement closeButton;

    @FindBy(css = "span.Cart_cart-title__DWz30")
    private ExtendedWebElement yourBagTitle;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void closeDialogIfPresent() {
        if (closeButton.isElementPresent()) {
            closeButton.click();
        }
    }

    public String getYourBagTitleText() {
        return yourBagTitle.getText().trim();
    }
}
