package com.solvd.laba.web.underarmour;

import com.solvd.laba.web.underarmour.pages.HomePage;
import com.solvd.laba.web.underarmour.pages.MensSectionPage;
import com.solvd.laba.web.underarmour.pages.ShoppingCartPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;


public class HomePageTest extends AbstractTest {

    @Test
    public void verifyNavigationToMensSection() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        MensSectionPage page = homePage.clickOnMensSection();

        String expectedUrl = "https://www.underarmour.com/en-us/c/mens/";
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));

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
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(searchTerm));
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
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String expectedUrl = "https://help.underarmour.com/s/";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(expectedUrl));
        String currentURL = driver.getCurrentUrl();
        sa.assertEquals(currentURL, expectedUrl, "The current URL should be the help page's URL.");

        sa.assertAll();
    }

    @Test
    public void verifyShoppingCartPageTitle() {

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCartIcon();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='user-action-close']")))
                .click();
        WebElement yourBagTitle = driver.findElement(By.cssSelector("span.Cart_cart-title__DWz30"));
        String expectedTitleText = "Your Bag";
        String actualTitleText = yourBagTitle.getText().trim();
        sa.assertTrue(actualTitleText.equals(expectedTitleText), "The cart title should be '" + expectedTitleText + "'.");

        sa.assertAll();
    }
}
