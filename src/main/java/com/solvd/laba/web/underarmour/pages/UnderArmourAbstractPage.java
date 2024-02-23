package com.solvd.laba.web.underarmour.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnderArmourAbstractPage extends AbstractPage {


    public UnderArmourAbstractPage(WebDriver driver) {

        super(driver);
    }

    public WebDriverWait waitSpinner() {

        return new WebDriverWait(driver, Duration.ofSeconds(7));
    }
}
