package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.vytrack.utilities.LogInLogOut.logIn;
import static com.vytrack.utilities.Variables.*;

public class PageAccessTest {
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
    public void test01_VehicleContractsTestStoreManager() throws InterruptedException {
        logIn("storemanager60","UserUser123");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//FLEET
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span")).click();//VEHICLE CONTRACTS
        Thread.sleep(5000);
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Vehicle Contract");

        softAssertion.assertAll();
    }

    @Test
    public void test02_VehicleContractsTestSalesManager() throws InterruptedException {
        logIn("salesmanager113","UserUser123");
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//FLEET
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span")).click();//VEHICLE CONTRACTS
        Thread.sleep(5000);
        softAssertion.assertEquals(driver.findElement(By.className(pageClassName)).getText(), "All Vehicle Contract");

        softAssertion.assertAll();
    }

    @Test
    public void test03_VehicleContractsTestTruckDriver() throws InterruptedException {
        logIn("user13","UserUser123");
        driver.findElement(By.className(fleetClassName)).click();//FLEET
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[6]/a/span")).click();//VEHICLE CONTRACTS
        Thread.sleep(3000);
        softAssertion.assertEquals(driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText(),
                "You do not have permission to perform this action.");

        softAssertion.assertAll();
    }




}
