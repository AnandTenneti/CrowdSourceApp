package com.crowdsource.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTasksPage {
    AndroidDriver driver;

    public UserTasksPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Crowdsource")
    private WebElement pageTitle;

    @AndroidFindBy(accessibility = "Get started")
    private WebElement getStartedButton;

    @AndroidFindBy(xpath = "(//android.view.View)[8]")
    private WebElement contributions;

    @AndroidFindBy(accessibility = "Image Label Verification")
    private WebElement imageLabelVerification;

    @AndroidFindBy(accessibility = "Image Capture")
    private WebElement imageCapture;

    @AndroidFindBy(accessibility = "Glide Type")
    private WebElement glideType;

    @AndroidFindBy(accessibility = "Smart Camera")
    private WebElement smartCamera;

    @AndroidFindBy(accessibility = "Translation Validation")
    private WebElement translationValidation;

    @AndroidFindBy(accessibility = "Learn why your help matters")
    private WebElement helpMattersLink;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Your help matters\"]")
    private WebElement helpMattersDialog;

    @AndroidFindBy(accessibility = "Got it")
    private WebElement gotItButton;

    @AndroidFindBy(xpath = "//(android.view.View)[2]//android.view.View")
    private List<WebElement> tabs;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Add\"]")
    private WebElement addLanguageButton;


    public void clickOnGetStartedButton() {
        getStartedButton.click();
    }

    public void clickOnImageLabelVerificationTile() {
        imageLabelVerification.click();
    }


    public void scrollToElement(String taskType) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(description(\"" + taskType + "\"));")).click();
    }

    public String getContributionCount() {
        return contributions.getAttribute("content-desc");
    }

    public WebElement getButtonDisplay() {
        return getStartedButton;
    }

    public void clickOnHelpMattersLink() {
        helpMattersLink.click();
    }

    public boolean isHelpDialogDisplayed() {
        return helpMattersDialog.isDisplayed();
    }

    public void clickOnGotitButton() {
        gotItButton.click();
    }

    public void clickOnTab(String elementText) {
        for(WebElement tab:tabs) {

            if(tab.getAttribute("content-desc").contains(elementText)){
                System.out.println(tab.getAttribute("content-desc"));
                tab.click();
                break;
            }
        }
    }


    public void longPress(String elementText) {
        for (WebElement tab : tabs) {
            if (tab.getAttribute("content-desc").contains(elementText)) {
                ((JavascriptExecutor) driver)
                        .executeScript("mobile: longClickGesture",
                                ImmutableMap.of("elementId", ((RemoteWebElement) tab).getId(),
                                        "duration", 1000));
            }
        }
    }
    public void clickOnAddLanguageButton() {
        addLanguageButton.click();
    }

    public void clickOnTranslationValidation() {
        translationValidation.click();
    }
    public WebElement getPageTitle(){
        return pageTitle;
    }
}
