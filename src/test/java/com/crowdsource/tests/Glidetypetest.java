package com.crowdsource.tests;

import com.crowdsource.pages.GlideType;
import com.crowdsource.pages.ImageCategoriesPage;
import com.crowdsource.pages.ImageDetailsPage;
import com.crowdsource.pages.UserTasksPage;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Glidetypetest extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Test(priority = 1)
    public void TC_1() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.scrollToElement("Glide Type");
        //tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(3000);
        scrollToElement("Glide Type");
        // ImageCategoriesPage imageCategories = new ImageCategoriesPage(driver);
        //imageCategories.scrollToElement("Skiing");

        // imageCategories.searchForImageUntilEnd();
    }

    @Test(priority = 2)
    public void TC_2() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        //tasksPage.clickOnImageLabelVerificationTile();
        scrollToElement("Glide Type");
        GlideType glideType = new GlideType(driver);
        glideType.clickOnContinueButton();
        glideType.clickOnGotItButton();
        Thread.sleep(3000);
        glideType.addTextInput("!@abcdefghij");
        //glideType.addTextInput("qr st uv wx yz");
//android.view.View[@content-desc="Use glide typing instead of tap typing."]
        //String validateMessage = glideType.getValidationMessage();
        // System.out.println(validateMessage);
        Thread.sleep(10000);
        glideType.getValidationMessage();
        //Assert.assertTrue(glideType.getValidationMessage().contains("Use glide typing instead of tap"));

    }


}
