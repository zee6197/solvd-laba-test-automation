package com.solvd.laba.web.amazon;

import com.solvd.laba.web.amazon.components.ProductCard;
import com.solvd.laba.web.amazon.pages.HomePage;
import com.solvd.laba.web.amazon.components.SearchLineComponent;
import com.solvd.laba.web.amazon.pages.SearchPage;
import com.zebrunner.carina.core.AbstractTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchLineTest() {

        String brandName = "iPhone";
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        sa.assertTrue(searchLineComponent.getProductTypesSelect().isElementPresent(5),"Product type select is not present");
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(5),"Search input is not present");
        sa.assertEquals(searchLineComponent.getSearchInputPlaceholder(),"Search Amazon","Search input has an incorrect placeholder");
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(5),"Search button is not present");

        searchLineComponent.typeSearchInputValue(brandName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();

        sa.assertTrue(driver.getCurrentUrl().contains(brandName.toLowerCase()), "Url doesn't contain the brand name");

        List<ProductCard> cards = searchPage.getCards();
        for (ProductCard card : cards) {
            sa.assertTrue(card.getTitleText().toLowerCase().contains(brandName.toLowerCase()), "Product with name ");
        }
        sa.assertAll();
    }
}
