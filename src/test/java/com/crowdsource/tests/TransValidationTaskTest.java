package com.crowdsource.tests;

import com.crowdsource.pages.TransValidationPage;
import com.crowdsource.pages.UserTasksPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TransValidationTaskTest extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test(priority = 1,groups = {"functional"})
    public void test_submitTranslationValidation() throws Exception {
        Thread.sleep(1000); 
        UserTasksPage tasksPage = new UserTasksPage(driver);
        wait.until(ExpectedConditions.visibilityOf(tasksPage.getButtonDisplay()));
        tasksPage.clickOnGetStartedButton();
       wait.until(ExpectedConditions.visibilityOf(tasksPage.getPageTitle()));
        scrollToEnd();
        tasksPage.clickOnTranslationValidation();
        TransValidationPage transValidationPage = new TransValidationPage(driver);
        wait.until(ExpectedConditions.visibilityOf(transValidationPage.getPageTitle()));
        String displayedTextBeforeSubmit = transValidationPage.getInputTranslationText();
        System.out.println("Translation text is " +displayedTextBeforeSubmit);
        transValidationPage.submitTranslationValidation();
        String displayedTextAfterSubmit=transValidationPage.getInputTranslationText();
        System.out.println("Translation text is " +displayedTextAfterSubmit);
        Assert.assertNotEquals(displayedTextBeforeSubmit,displayedTextAfterSubmit);
    }
}
