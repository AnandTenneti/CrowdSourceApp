package com.crowdsource.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImageCategoriesPage {
    AndroidDriver driver;

    public ImageCategoriesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement searchImageCategoryInput;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"smile\"]")
    private WebElement imageCategory;

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;

    public void searchForImageCategory(String category) {
        searchImageCategoryInput.click();
        searchImageCategoryInput.sendKeys(category);
        List<WebElement> categoryTiles =
                driver.findElements(By.xpath("//android.widget.ImageView"));
        for (WebElement categoryTile : categoryTiles) {
            System.out.println(categoryTile.getAttribute("content-desc"));
            if (categoryTile.getAttribute("content-desc").equalsIgnoreCase(category)) {
                System.out.println(categoryTile.getAttribute("content-desc"));
                categoryTile.click();
                break;
            } else if (categoryTile.getAttribute("content-desc").contains(category)) {
                System.out.println("hello");
                categoryTile.click();
                break;
            }
        }

    }

    public void searchImageCategory(String category) {
        searchImageCategoryInput.click();
        searchImageCategoryInput.sendKeys(category);

//        List<WebElement> categoryTiles =
//                driver.findElements(By.xpath("//android.widget.ImageView"));
//        for (WebElement categoryTile : categoryTiles) {
//            if (categoryTile.getAttribute("content-desc").equalsIgnoreCase(category)) {
//                categoryTile.click();
//                break;
//            }
//        }

    }

    public void clearTectField() {
        searchImageCategoryInput.clear();
    }

    public void searchForImageUntilEnd() throws InterruptedException {
        searchImageCategoryInput.click();
        searchImageCategoryInput.sendKeys(Keys.COMMAND);
        searchImageCategoryInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200,
                            "height", 200, "direction", "down",
                            "percent", 3.0));
            Thread.sleep(2000);
        } while (canScrollMore);


    }

    public void scrollToElement(String category) {
        driver.findElement(AppiumBy.
                androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(description(\"" + category + "\"));"));
    }

    public void clickOnBackButton() {
        backButton.click();
    }

}
