package com.crowdsource.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class GlideType {
    AndroidDriver driver;

    public GlideType(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    /// Elements section
    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement inputGlideText;

    @AndroidFindBy(accessibility = "Submit")
    private WebElement sendButton;

    @AndroidFindBy(accessibility = "Use glide typing instead of tap typing.")
    private WebElement glideType;

    @AndroidFindBy(xpath = "//android.view.View")
    private List<WebElement> validationMessage;

    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipButton;

    @AndroidFindBy(accessibility = "Previous")
    private WebElement previousButton;

    @AndroidFindBy(accessibility = "Got it")
    private WebElement gotItButton;


    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnSubmitButton() {
        sendButton.click();
    }

    public void getValidationMessage() {
        for (WebElement vmesg : validationMessage) {
            System.out.println(vmesg.getAttribute("content-desc"));
        }
    }

    public void clickOnGotItButton() {
        gotItButton.click();
    }

    public void addTextInput(String textInput) {
        Random r = new Random();
        for (int i = 0; i < textInput.length(); i++) {
            try {
                Thread.sleep((int) (r.nextGaussian() * 10 + 100));
            } catch (InterruptedException e) {
            }
            String s = new StringBuilder().append(textInput.charAt(i)).toString();
            inputGlideText.sendKeys(s);
        }

    }

}
