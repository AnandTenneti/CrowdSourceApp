package com.crowdsource.utils;

import com.crowdsource.tests.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListenerClass extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName() + ".png");
    }
}
