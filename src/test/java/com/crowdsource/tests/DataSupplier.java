package com.crowdsource.tests;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider(name = "categoriesTestData", indices = {0,2})
    public String[] categoryData() {
        String[] data = new String[]{"Smile","Skiing","Reefs","Horse"};
        return data;
    }

    @DataProvider(name = "tabsTestData")
    public String[] tabData() {
        String[] data = new String[3];
        data[0] = "Home";
        data[1] = "Leaderboards";
        data[2] = "Achievements";
        return data;
    }

    @DataProvider(name = "languagesTestData")
    public String[] fluentLanguagesData() {
        String[] data = new String[]{"Telugu", "Kannada"};
        return data;
    }

}
