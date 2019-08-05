package com.vytrack.tests;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod() {
        // initilializes the webdriver object in test base class using the Driver utility
        driver = Driver.get();
        driver.manage().window().maximize();

        // setting implicit wait --> when elements not found, it will keep trying to find it for 10 seconds
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        // set up the explicit wait object.
        wait = new WebDriverWait(driver, 10) ;

        // Actions class enable advanced interactions like double click, drag drop ...
        actions = new Actions(driver);



    }

    @AfterMethod
    public void tearDownMethod()  {

      Driver.closeDriver();
    }


}