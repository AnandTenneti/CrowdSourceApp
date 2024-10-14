package com.crowdsource.tests;

import com.crowdsource.pages.ImageCategoriesPage;
import com.crowdsource.pages.ImageDetailsPage;
import com.crowdsource.pages.UserTasksPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderTests extends BaseTest {

    /*** Data Provider Tests
     *
     * @param category
     * @throws Exception
     */

    @Test(priority = 1, dataProvider = "categoriesTestData", dataProviderClass = DataSupplier.class)
    public void TC_1(String category) throws Exception {
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

    @Test(priority = 2, dataProvider = "tabsTestData", dataProviderClass = DataSupplier.class)
    public void test_longPressTabs(String tab) throws InterruptedException {
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