package com.crowdsource.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TransValidationPage {
    AndroidDriver driver;

    public TransValidationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    private WebElement correctOption;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc])[1]")
    private WebElement title;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc])[3]")
    private WebElement translationText;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    private WebElement incorrectOption;

    @AndroidFindBy(accessibility = "Submit")
    private WebElement submitButton;

    @AndroidFindBy(accessibility = "Previous")
    private WebElement previousButton;

    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipButton;

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void clickOnYesButton() {
        submitButton.click();
    }
    public String getInputTranslationText(){
        return translationText.getAttribute("content-desc");
    }

    public void clickOnBackButton() {
        backButton.click();
    }

    public void clickOnSkipButton() {
        skipButton.click();
    }

    public void submitTranslationValidation() {
        correctOption.click();
        if (submitButton.isEnabled()) {
            submitButton.click();
        }
    }

    public WebElement getPageTitle() {
        return title;
    }


}
