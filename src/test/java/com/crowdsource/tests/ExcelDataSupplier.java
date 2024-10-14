package com.crowdsource.tests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExcelDataSupplier {
    @DataProvider(name="tabsTestData")
    public String[][] getData() throws IOException {
        File excelFile = new File(System.getProperty("user.dir")+"/src/test/resources/Test.xlsx");
        System.out.println(excelFile.exists());
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
       // System.out.println(sheet.getPhysicalNumberOfRows());
        //System.out.println(sheet.getLastRowNum());
        int noOfRows =  sheet.getPhysicalNumberOfRows();
        int noOfColumns= sheet.getRow(0).getLastCellNum();
        System.out.println(noOfRows);
        System.out.println(noOfColumns);
        String[][] data = new String[noOfRows-1][noOfColumns];
        for(int i =0; i < sheet.getLastRowNum();i++){
            DataFormatter df = new DataFormatter();
            data[i][0]=df.formatCellValue(sheet.getRow(i+1).getCell(0));
        }
        workbook.close();
        fis.close();
        return data;
    }
}
