package com.crowdsource.tests;

import com.crowdsource.pages.ImageCategoriesPage;
import com.crowdsource.pages.ImageDetailsPage;
import com.crowdsource.pages.UserTasksPage;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Misctest extends BaseTest {


    @Test(priority = 2, groups = {"functional"})
    public void test_screenOrientation() throws Exception {
        Thread.sleep(3000);
        ScreenOrientation orientation = driver.getOrientation();
        System.out.println("Current Orientation is " + orientation);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(3000);
        ImageCategoriesPage imageCategories = new ImageCategoriesPage(driver);
        imageCategories.searchForImageCategory("Smile");
        Thread.sleep(5000);
    }
}
