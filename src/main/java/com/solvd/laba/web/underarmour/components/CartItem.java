package com.solvd.laba.web.underarmour.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartItem {

    private WebDriver driver;

    @FindBy(xpath = ".//div[contains(@class, 'CartItem_cart-item__')]//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = ".//a[contains(@class, 'CartItem_name')]")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//div[contains(@class, 'CartItem_price')]//span[contains(@class, 'bfx-price bfx-list-price')]")
    private ExtendedWebElement productPrice;


    public CartItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {

        return productName.getText();
    }

    public String getProductPrice() {

        return productPrice.getText();
    }
}
