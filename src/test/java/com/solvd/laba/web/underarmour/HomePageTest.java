package com.solvd.laba.web.underarmour;

import com.solvd.laba.web.underarmour.pages.HomePage;
import com.solvd.laba.web.underarmour.pages.MensSectionPage;
import com.solvd.laba.web.underarmour.pages.ShoppingCartPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;


public class HomePageTest extends AbstractTest {


    // TODO: Feedback: Good practice to create the whole navigation bar using ENUM and then test the navigation bar using the ENUM!
    // TODO: Practice: Look for more abstraction in tests and create abstraction layer as needed
    @Test
    public void verifyNavigationToMensSection() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        MensSectionPage page = homePage.clickOnMensSection();

        // TODO: feedback: also include this in ENUM and include the header text to test
        String expectedUrl = "https://www.underarmour.com/en-us/c/mens/";
        homePage.waitSpinner().until(ExpectedConditions.urlToBe(expectedUrl));
        String currentURL = driver.getCurrentUrl();
        sa.assertEquals(currentURL, expectedUrl, "The current URL should be the Men's section URL.");

        sa.assertAll();
    }

    @Test
    public void searchFunctionalityTest() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        String searchTerm = "shoes";
        homePage.enterSearchTermAndSubmit(searchTerm);
        homePage.waitSpinner().until(ExpectedConditions.urlContains(searchTerm));
        String currentURL = driver.getCurrentUrl();
        sa.assertTrue(currentURL.contains(searchTerm), "The URL should contain the search term.");

        sa.assertAll();
    }

    @Test
    public void verifyNavigationToNeedHelp() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickOnNeedHelp();

        homePage.waitSpinner().until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // switch to the second tab
        driver.switchTo().window(tabs.get(1));
        String expectedUrl = "https://help.underarmour.com/s/";
        homePage.waitSpinner().until(ExpectedConditions.urlToBe(expectedUrl));
        String currentURL = driver.getCurrentUrl();
        sa.assertEquals(currentURL, expectedUrl, "The current URL should be the help page's URL.");

        // close the second tab
        driver.close();
        // switch to the first tab
        driver.switchTo().window(tabs.get(0));

        sa.assertAll();
    }

    @Test
    public void verifyShoppingCartPageTitle() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCartIcon();

        shoppingCartPage.waitSpinner();
        shoppingCartPage.closeDialogIfPresent();
        String expectedTitleText = "Your Bag";
        String actualTitleText = shoppingCartPage.getYourBagTitleText();
        sa.assertTrue(actualTitleText.equals(expectedTitleText), "The cart title should be '" + expectedTitleText + "'.");

        sa.assertAll();
    }
}
