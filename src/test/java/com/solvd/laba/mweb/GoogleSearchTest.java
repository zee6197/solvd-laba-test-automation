//package com.solvd.laba.mweb;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.ios.IOSDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.Properties;
//
//public class GoogleSearchTest {
//    private AppiumDriver<MobileElement> driver;
//    private GoogleSearchPage googleSearchPage;
//    private Properties props;
//    private static final String URL = "https://www.google.com";
//
//    @BeforeClass
//    public void setUp() throws Exception {
//        props = new Properties();
//        InputStream input = new FileInputStream("src/main/resources/_config.properties");
//
//        props.load(input);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", props.getProperty("capabilities.platformName"));
//        capabilities.setCapability("deviceName", props.getProperty("capabilities.deviceName"));
//        capabilities.setCapability("automationName", props.getProperty("capabilities.automationName"));
//        capabilities.setCapability("platformVersion", props.getProperty("capabilities.platformVersion"));
//        capabilities.setCapability("browserName", props.getProperty("capabilities.browserName"));
//
//
//        String appiumUrl = props.getProperty("appium_url");
//        driver = new IOSDriver<>(new URL(appiumUrl), capabilities);
//        googleSearchPage = new GoogleSearchPage(driver);
//    }
//
//    @Test
//    public void testSHomePage() {
//        SoftAssert sa = new SoftAssert();
//        driver.get(URL);
//
//        String pageTitle = driver.getTitle();
//        sa.assertEquals(pageTitle, "Google", "The page title should be Google.");
//
//        sa.assertAll();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
