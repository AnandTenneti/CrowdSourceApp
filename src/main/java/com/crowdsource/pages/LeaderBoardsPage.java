package com.crowdsource.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class LeaderBoardsPage {
    AndroidDriver driver;

    public LeaderBoardsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    @AndroidFindBy(accessibility = "Join")
    private List<WebElement> joinButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc])[1]")
    private WebElement title;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[@content-desc]")
    private List<WebElement> contributionsCategories;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Smart Camera\"]/following-sibling::android.view.View")
    private List<WebElement> userRank;

    @AndroidFindBy(accessibility = "Submit")
    private WebElement submitButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Leaderboards\"]/following" +
            "-sibling" +
            "::android.widget.Button")
    private WebElement dottedLinesMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Help\"]")
    private WebElement helpButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Leave\"]")
    private WebElement leaveButton;

    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc][2]")
    private WebElement userPoints;


    public void clickOnJoinButton() {
        joinButton.get(0).click();
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void clickOnYesButton() {
        submitButton.click();
    }

    public void clickOnContributionsInCategories(String categoryText) {
        for (WebElement contributions : contributionsCategories) {
            if (contributions.getAttribute("content-desc").contains(categoryText)) {
                contributions.click();
                break;
            }
        }
    }

    public String getRankDetailsInCategory() {
        if (userRank.size() == 1) {
            return userRank.get(0).getAttribute("content-desc");
        } else if (userRank.size() > 1) {
            return userRank.get(1).getAttribute("content-desc");
        }
        return "Something is incorrect, please check again";
    }

    public boolean isJoinButtonDisplayed() {
        return joinButton.size() > 0;
    }

    public void clickOnBackButton() {
        backButton.click();
    }

    public WebElement getPageTitle() {
        return title;
    }

    public void clickOnDottedLineMenu() {
        dottedLinesMenu.click();
    }

    public void clickOnLeaveButton() {
        leaveButton.click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Leave\"]")).click();
    }

    public void clickOnHelpButton() {
        helpButton.click();
    }

    public void clickOnLink() {
        driver.findElement(By.xpath("//android.webkit.WebView[@resource-id=\"com.google.android" +
                ".gms:id/gh_answer_content\"]")).click();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
    }
    public String showUserPoints() {
        String userpointValue = userPoints.getAttribute("content-desc");

       return userpointValue;
    }
}
