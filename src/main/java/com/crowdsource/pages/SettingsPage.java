package com.crowdsource.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingsPage {
    AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Add a language\"]")
    private WebElement addFluentLanguageButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Afar\"]/android.widget.Button")
    private WebElement languageButton;

    public void clickOnAddFluentLanguageButton() {
        addFluentLanguageButton.click();
    }

    public void clickOnLanguageButtonAndRemove(String language) {
        driver.findElement(
                        By.xpath(
                                "//android.view.View[@content-desc=\"" + language + "\"]/android.widget.Button"))
                .click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Remove\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Confirm\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Language removed.")).isDisplayed();

    }


}
