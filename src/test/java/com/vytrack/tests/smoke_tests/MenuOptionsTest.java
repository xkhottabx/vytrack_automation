package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.vytrack.utilities.Variables.*;
import static com.vytrack.utilities.LogInLogOut.*;


public class MenuOptionsTest {

    SoftAssert softAssertion = new SoftAssert();

    @BeforeClass
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }




    @Test
    public void test01_MenuOptionsDriver() throws InterruptedException {
        logIn("user13","UserUser123");
        driver.findElement(By.className(fleetClassName)).click();//FLEET
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();//VEHICLES
        Thread.sleep(6000);
        softAssertion.assertEquals(driver.getTitle(), "Car - Entities - System - Car - Entities - System");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Cars");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//CUSTOMERS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();//ACCOUNTS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "Accounts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Accounts");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//CUSTOMERS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span")).click();//CONTACTS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "Contacts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Contacts");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]")).click();//ACTIVITIES
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span")).click();//CALENDAR EVENTS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "Calendar Events - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Calendar Events");

        softAssertion.assertAll();
    }

    @Test
    public void test02_MenuOptionsStoreManager() throws InterruptedException {

        logIn("storemanager60","UserUser123");

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();//DASHBOARDS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();//DASHBOARD
        Thread.sleep(3000);
        softAssertion.assertEquals(driver.getTitle(), "Dashboard - Dashboards");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Dashboard");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//FLEET
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();//VEHICLES
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "All - Car - Entities - System - Car - Entities - System");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Cars");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();//CUSTOMERS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span")).click();//ACCOUNTS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "All - Accounts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Accounts");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();//CUSTOMERS
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[4]/a/span")).click();//CONTACTS
        Thread.sleep(4000);
        softAssertion.assertEquals(driver.getTitle(), "All - Contacts - Customers");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Contacts");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/a/span")).click();//SALES

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/div/div/ul/li[3]/a/span")).click();//OPPORTUNITIES
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "Open Opportunities - Opportunities - Sales");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "Open Opportunities");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span")).click();//ACTIVITIES
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[3]/a/span")).click();//CALLS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "All - Calls - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Calls");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span")).click();//ACTIVITIES
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span")).click();//CALENDAR EVENTS
        Thread.sleep(2000);
        softAssertion.assertEquals(driver.getTitle(), "All - Calendar Events - Activities");
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Calendar Events");

        softAssertion.assertAll();

    }

}
