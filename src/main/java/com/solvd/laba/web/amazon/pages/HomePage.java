package com.solvd.laba.web.amazon.pages;

import com.solvd.laba.web.amazon.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {


    @FindBy(xpath = "//header")
    private Header header;

    public HomePage(WebDriver driverAmz) {
        super(driverAmz);
//        setPageURL("/");
//        setPageAbsoluteURL(Configuration.getRequired("amazon_home_url"));
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("amazon_home_url"));
    }

    public Header getHeader() {
        return header;
    }
}
