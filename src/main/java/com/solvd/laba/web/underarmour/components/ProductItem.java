package com.solvd.laba.web.underarmour.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem {

    private WebDriver driver;


    @FindBy(id = ".//div[starts-with(@id, 'product-')]")
    private ExtendedWebElement productImage;

    @FindBy(id = "product-title-{productId}")
    private ExtendedWebElement productTitle;


    public ProductItem(WebDriver driver) {
        this.driver = driver;
    }

    public ExtendedWebElement getProductImage() {

        return productImage;
    }

    public String getProductTitle() {

        return productTitle.getText();
    }


    public void clickProduct() {

        productImage.click();
    }
}
