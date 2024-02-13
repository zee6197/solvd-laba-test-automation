package com.solvd.laba.web.underarmour.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer {

    private WebDriver driver;

    @FindBy(xpath = ".//input[@id='email']")
    private ExtendedWebElement newsletterEmailInput;

    @FindBy(xpath = ".//button[contains(@class, 'EmailForm_email__submit')]")
    private ExtendedWebElement newsletterSubmitButton;

    @FindBy(xpath = ".//a[text()='Terms & Conditions']")
    private ExtendedWebElement termsAndConditionsLink;


    public Footer(WebDriver driver) {
        super();
    }

    public void enterNewsletterEmail(String email) {
        newsletterEmailInput.clear();
        newsletterEmailInput.sendKeys(email);
    }

    public void submitNewsletter() {

        newsletterSubmitButton.click();
    }

    public void clickTermsAndConditions() {

        termsAndConditionsLink.click();
    }
}
