//package com.solvd.laba.mweb;
//
//import com.zebrunner.carina.webdriver.gui.AbstractPage;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//
//public class GoogleSearchPage extends AbstractPage {
//
//    private AppiumDriver<MobileElement> driver;
//
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='q']")
//    private MobileElement searchBar;
//
//    public GoogleSearchPage(AppiumDriver<MobileElement> driver) {
//        super(driver);
//    }
//
//    public void enterSearchTerm(String searchTerm) {
//
//        searchBar.sendKeys(searchTerm);
//    }
//
//    public boolean isSearchBarDisplayed() {
//
//        return searchBar.isDisplayed();
//    }
//}
