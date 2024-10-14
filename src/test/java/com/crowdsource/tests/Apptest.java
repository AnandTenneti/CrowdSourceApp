package com.crowdsource.tests;

import com.crowdsource.pages.ImageCategoriesPage;
import com.crowdsource.pages.ImageDetailsPage;
import com.crowdsource.pages.UserTasksPage;
import com.crowdsource.utils.Utilities;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

public class Apptest extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void TC_1() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(3000);
        ImageCategoriesPage imageCategories = new ImageCategoriesPage(driver);
        imageCategories.searchForImageCategory("cat");
        Thread.sleep(5000);
        //TakesScreenshot ts = (TakesScreenshot)driver;
       // File file = ts.getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/Screenshots/Image1" +
         //       ".png"));
       // String base64Code = ts.getScreenshotAs(OutputType.BASE64);
       // byte[] byteArray = Base64.getDecoder().decode(base64Code);
        //FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir")+
       //         "/Screenshots/Image1" +
         //              ".jpeg"));
//        byte[] byteArray = ts.getScreenshotAs(OutputType.BYTES);
//        FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir")+
//                "/Screenshots/Image_bytes" +
//                ".jpeg"));
//        fos.write(byteArray);
//        fos.close();
    }

    @Test(priority = 2)
    public void TC_2() throws Exception {
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
        imageCategories.searchForImageCategory("cats");
        Thread.sleep(5000);

    }

    @Test(priority = 3)
    public void TC_3() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(3000);
        ImageCategoriesPage imageCategories = new ImageCategoriesPage(driver);
        scrollToElement("Moon");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void TC_4() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(2000);
        String contributionsCount = tasksPage.getContributionCount();
        System.out.println("The total no. of contributions is " + contributionsCount);
        String submittedContributions = contributionsCount.substring(0, 4);
        int submittedContributionsCount = Integer.parseInt(submittedContributions);
        System.out.println("Submitted contributions is " + submittedContributionsCount);
        Thread.sleep(2000);
        tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(2000);
        ImageCategoriesPage imageCategoriesPage = new ImageCategoriesPage(driver);
        imageCategoriesPage.searchForImageCategory("Skiing");
        ImageDetailsPage imageDetailsPage = new ImageDetailsPage(driver);
        Thread.sleep(2000);
        imageDetailsPage.clickOnYesButton();
        Thread.sleep(2000);
        imageDetailsPage.clickOnBackButton();
        imageCategoriesPage = new ImageCategoriesPage(driver);
        imageCategoriesPage.clickOnBackButton();
        Thread.sleep(2000);
        tasksPage = new UserTasksPage(driver);
        Thread.sleep(2000);
        String updated_contributionsCount = tasksPage.getContributionCount();
        System.out.println("The total no. of contributions is " + updated_contributionsCount);
        String updated_submittedContributions = updated_contributionsCount.substring(0, 4);
        int updated_submittedContributionsCount = Integer.parseInt(updated_submittedContributions);
        System.out.println("Submitted contributions is " + updated_submittedContributionsCount);
        Assert.assertEquals(submittedContributionsCount + 1, updated_submittedContributionsCount, "not Incremented by 1");
    }

    @Test(priority = 5)
    public void TC_5() throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnHelpMattersLink();
        Assert.assertTrue(tasksPage.isHelpDialogDisplayed());
        tasksPage.clickOnGotitButton();
        Thread.sleep(3000);
    }

    /*** Data Provider Tests
     *
     * @param category
     * @throws Exception
     */

    @Test(priority = 6, dataProvider = "categoriesTestData", dataProviderClass = DataSupplier.class)
    public void TC_6(String category) throws Exception {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnImageLabelVerificationTile();
        Thread.sleep(3000);
        ImageCategoriesPage imageCategories = new ImageCategoriesPage(driver);
        imageCategories.searchForImageCategory(category);
        Thread.sleep(5000);

    }

    @Test(priority = 7, dataProvider = "tabsTestData", dataProviderClass = DataSupplier.class)
    public void TC_7(String tab) throws InterruptedException {
        Thread.sleep(3000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        Thread.sleep(3000);
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.longPress(tab);
        Thread.sleep(3000);
    }
}
