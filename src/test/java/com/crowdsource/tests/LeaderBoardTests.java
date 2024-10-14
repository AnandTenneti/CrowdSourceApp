package com.crowdsource.tests;

import com.crowdsource.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LeaderBoardTests extends BaseTest {

//    @Test(priority = 1, dataProvider = "languagesTestData", dataProviderClass = DataSupplier.class)
//    public void TC_1(String language) throws Exception {
//        Thread.sleep(3000);
//        UserTasksPage tasksPage = new UserTasksPage(driver);
//        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
//        tasksPage.clickOnGetStartedButton();
//        Thread.sleep(3000);
//        scrollToEnd();
//        Thread.sleep(3000);
//        tasksPage.clickOnAddLanguageButton();
//        Thread.sleep(3000);
//        SettingsPage settingsPage = new SettingsPage(driver);
//        settingsPage.clickOnAddFluentLanguageButton();
//        Thread.sleep(5000);
//        scrollToElement(language);
//        Thread.sleep(5000);
//        settingsPage.clickOnLanguageButtonAndRemove(language);
//    }
//
//    @Test(priority = 2, groups = {"regression"})
//    public void TC_4() throws Exception {
//        Thread.sleep(3000);
//        UserTasksPage tasksPage = new UserTasksPage(driver);
//        tasksPage.clickOnGetStartedButton();
//        Thread.sleep(2000);
//        String contributionsCount = tasksPage.getContributionCount();
//        System.out.println("The total no. of contributions is " + contributionsCount);
//        String submittedContributions = contributionsCount.substring(0, 4);
//        int submittedContributionsCount = Integer.parseInt(submittedContributions);
//        System.out.println("Submitted contributions is " + submittedContributionsCount);
//        Thread.sleep(2000);
//        tasksPage.clickOnImageLabelVerificationTile();
//        Thread.sleep(2000);
//        ImageCategoriesPage imageCategoriesPage = new ImageCategoriesPage(driver);
//        imageCategoriesPage.searchForImageCategory("Skiing");
//        ImageDetailsPage imageDetailsPage = new ImageDetailsPage(driver);
//        Thread.sleep(2000);
//        imageDetailsPage.clickOnYesButton();
//        Thread.sleep(2000);
//        imageDetailsPage.clickOnBackButton();
//        imageCategoriesPage = new ImageCategoriesPage(driver);
//        imageCategoriesPage.clickOnBackButton();
//        Thread.sleep(2000);
//        tasksPage = new UserTasksPage(driver);
//        Thread.sleep(2000);
//        String updated_contributionsCount = tasksPage.getContributionCount();
//        System.out.println("The total no. of contributions is " + updated_contributionsCount);
//        String updated_submittedContributions = updated_contributionsCount.substring(0, 4);
//        int updated_submittedContributionsCount = Integer.parseInt(updated_submittedContributions);
//        System.out.println("Submitted contributions is " + updated_submittedContributionsCount);
//        Assert.assertEquals(submittedContributionsCount + 1, updated_submittedContributionsCount, "not Incremented by 1");
//    }
//
//    @Test(priority = 3, groups = {"functional", "regression"})
//    public void TC_5() throws Exception {
//        Thread.sleep(3000);
//        UserTasksPage tasksPage = new UserTasksPage(driver);
//        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
//        tasksPage.clickOnGetStartedButton();
//        Thread.sleep(3000);
//        tasksPage.clickOnHelpMattersLink();
//        Assert.assertTrue(tasksPage.isHelpDialogDisplayed());
//        tasksPage.clickOnGotitButton();
//        Thread.sleep(3000);
//    }
//
//    /**
//     * @param tab
//     * @throws InterruptedException
//     */
//
//    @Test(priority = 4, dataProvider = "tabsTestData", dataProviderClass = ExcelDataSupplier.class)
//    public void TC_7(String tab) throws InterruptedException {
//        Thread.sleep(3000);
//        UserTasksPage tasksPage = new UserTasksPage(driver);
//        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
//        Thread.sleep(3000);
//        tasksPage.clickOnGetStartedButton();
//        Thread.sleep(3000);
//        tasksPage.longPress(tab);
//        Thread.sleep(3000);
//    }

    @Test(priority = 5, groups = {"functional"})
    public void TC_9() throws Exception {
        Thread.sleep(1000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        //wait.until(ExpectedConditions.visibilityOf(tasksPage.getPageTitle()));
        Thread.sleep(3000);
        tasksPage.clickOnTab("Leaderboards");
        Thread.sleep(3000);
        LeaderBoardsPage leaderBoardsPage = new LeaderBoardsPage(driver);
        if (leaderBoardsPage.isJoinButtonDisplayed()) {
            leaderBoardsPage.clickOnJoinButton();
        }
        Thread.sleep(1000);

        leaderBoardsPage.clickOnContributionsInCategories("Image Label Verification");
        Thread.sleep(5000);
        String userRankDetails = leaderBoardsPage.getRankDetailsInCategory();
        System.out.println("Your User rank is " + userRankDetails);
    }

    @Test(priority = 5, groups = {"functional"})
    public void test_joinAndLeaveLeaderBoards() throws Exception {
        Thread.sleep(1000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        Thread.sleep(3000);
        tasksPage.clickOnTab("Leaderboards");
        Thread.sleep(3000);
        LeaderBoardsPage leaderBoardsPage = new LeaderBoardsPage(driver);
        if (leaderBoardsPage.isJoinButtonDisplayed()) {
            leaderBoardsPage.clickOnJoinButton();
        }
        Thread.sleep(3000);
        leaderBoardsPage.clickOnDottedLineMenu();
        leaderBoardsPage.clickOnLeaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(leaderBoardsPage.isJoinButtonDisplayed());
    }

    @Test(priority = 5)
    public void TC_10() throws Exception {
        Thread.sleep(1000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        // wait.until(ExpectedConditions.visibilityOf(tasksPage.getPageTitle()));
        Thread.sleep(3000);
        tasksPage.clickOnTab("Leaderboards");
        Thread.sleep(3000);
        LeaderBoardsPage leaderBoardsPage = new LeaderBoardsPage(driver);
        Thread.sleep(3000);
        if (leaderBoardsPage.isJoinButtonDisplayed()) {
            leaderBoardsPage.clickOnJoinButton();
        }
        Thread.sleep(3000);
        leaderBoardsPage.clickOnDottedLineMenu();
        Thread.sleep(3000);
        leaderBoardsPage.clickOnHelpButton();
        // Thread.sleep(3000);
        //leaderBoardsPage.clickOnLink();
        Thread.sleep(2000);
        leaderBoardsPage.clickOnBackButton();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods ="test_joinAndLeaveLeaderBoards" )
    public void TC_11() throws InterruptedException {
        Thread.sleep(1000);
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
        // wait.until(ExpectedConditions.visibilityOf(tasksPage.getPageTitle()));
        Thread.sleep(3000);
        tasksPage.clickOnTab("Leaderboards");
        Thread.sleep(3000);
        LeaderBoardsPage leaderBoardsPage = new LeaderBoardsPage(driver);
        Thread.sleep(3000);
        if (leaderBoardsPage.isJoinButtonDisplayed()) {
            String userPoints = leaderBoardsPage.showUserPoints();
            String regexpPattern = "[^0-9]";
            extractIntegersFromAString(regexpPattern, userPoints);
        }
        Thread.sleep(3000);
    }
}
