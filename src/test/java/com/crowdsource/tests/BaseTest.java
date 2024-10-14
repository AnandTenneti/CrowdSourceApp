package com.crowdsource.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;


public class BaseTest {
    public static AndroidDriver driver;
    public AppiumDriverLocalService service;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    FileInputStream fis;
    public static String PATH_TO_JS = "/usr/local/lib/node_modules/appium/build/lib/main.js";

    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/com/crowdsource/configuration/config.properties");
        properties.load(fis);
        return properties;

    }

    @BeforeSuite(groups = {"dailybuild"})
    public void configureAppium() throws IOException {
        Properties prop = getProperties();
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(PATH_TO_JS))
                .withIPAddress(prop.getProperty("IPAddress"))
                .usingPort(4723).build();
        service.start();
    }

    @BeforeMethod(groups = {"dailybuild"})//
    public void setUp() throws URISyntaxException, IOException {
        Properties prop = getProperties();
        String app = prop.getProperty("app");
        String deviceName = prop.getProperty("devioeName");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(app);
        options.setDeviceName(deviceName);
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @AfterMethod(groups = {"dailybuild"})
    public void tearDown(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE){
            captureScreenshot(result.getTestContext().getName()+"_"+result.getName()+".jpg");
        }
        driver.quit();
    }

    @AfterSuite(groups = {"dailybuild"})
    public void stopAppium() {
        service.stop();
    }


    public void scrollToElement(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(description(\"" + elementText + "\"));")).click();
    }

    public void longPress(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("mobile: longClickGesture",
                        ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                                "duration", 1000));
    }

    void scrollToEnd() {
        System.out.println("Hello");
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
        } while (canScrollMore);
    }

    public void extractIntegersFromAString(String pattern, String text) {
        System.out.println(text.replaceAll(pattern, "").trim());

    }

    public static void captureScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,
                    new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ""));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
