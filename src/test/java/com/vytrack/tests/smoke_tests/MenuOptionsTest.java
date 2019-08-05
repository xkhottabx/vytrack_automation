package com.vytrack.tests.smoke_tests;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.vytrack.utilities.Variables.*;

public class MenuOptionsTest extends TestBase {

    SoftAssert softAssertion = new SoftAssert();

    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test01_MenuOptionsDriver() {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.selectMenuOption("Fleet", "Vehicles");
        softAssertion.assertEquals(driver.getTitle(), "Car - Entities - System - Car - Entities - System");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Cars");
        dashboardPage.selectMenuOption("Customers", "Accounts");
        softAssertion.assertEquals(driver.getTitle(), "Accounts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Accounts");
        dashboardPage.selectMenuOption("Customers", "Contacts");
        softAssertion.assertEquals(driver.getTitle(), "Contacts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Contacts");
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        softAssertion.assertEquals(driver.getTitle(), "Calendar Events - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Calendar Events");

        softAssertion.assertAll();
    }

    @Test
    public void test02_MenuOptionsStoreManager() {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.selectMenuOption("Dashboards", "Dashboard");
        softAssertion.assertEquals(driver.getTitle(), "Dashboard - Dashboards");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Dashboard");
        dashboardPage.selectMenuOption("Fleet", "Vehicles");
        softAssertion.assertEquals(driver.getTitle(), "All - Car - Entities - System - Car - Entities - System");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Cars");
        dashboardPage.selectMenuOption("Customers", "Accounts");
        softAssertion.assertEquals(driver.getTitle(), "All - Accounts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Accounts");
        dashboardPage.selectMenuOption("Customers", "Contacts");
        softAssertion.assertEquals(driver.getTitle(), "All - Contacts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Contacts");
        dashboardPage.selectMenuOption("Sales", "Opportunities");
        softAssertion.assertEquals(driver.getTitle(), "Open Opportunities - Opportunities - Sales");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Open Opportunities");
        dashboardPage.selectMenuOption("Activities", "Calls");
        softAssertion.assertEquals(driver.getTitle(), "All - Calls - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Calls");
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        softAssertion.assertEquals(driver.getTitle(), "All - Calendar Events - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Calendar Events");

        softAssertion.assertAll();

    }

}
