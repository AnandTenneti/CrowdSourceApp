package com.crowdsource.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImageDetailsPage {
    AndroidDriver driver;

    public ImageDetailsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;
    @AndroidFindBy(accessibility = "Yes")
    private WebElement yesButton;

    @AndroidFindBy(accessibility = "No")
    private WebElement noButton;

    @AndroidFindBy(accessibility = "Previous")
    private WebElement previousButton;

    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipButton;

    public void clickOnYesButton() {
        yesButton.click();
    }
    public void clickOnBackButton() {
        backButton.click();
    }


}
