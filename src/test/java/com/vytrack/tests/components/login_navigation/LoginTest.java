package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.vytrack.utilities.LogInLogOut.logIn;
import static com.vytrack.utilities.LogInLogOut.logOut;
import static com.vytrack.utilities.Variables.*;

public class LoginTest {

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
    public void test01_LoginTestPositive() throws InterruptedException {
        logIn("storemanager60","UserUser123");
        softAssertion.assertEquals(driver.findElement(By.id("user-menu")).getText(), "Mark Gusikowski");
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        logOut();
        logIn("salesmanager113","UserUser123");
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        softAssertion.assertFalse(driver.findElement(By.id("user-menu")).getText().equals("Mark Gusikowski"));
        logOut();
        logIn("user13","UserUser123");
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        softAssertion.assertEquals(driver.findElement(By.className("oro-subtitle")).getText(), "Quick Launchpad");
        softAssertion.assertFalse(driver.findElement(By.id("user-menu")).getText().equals("Roselyn Little"));

        softAssertion.assertAll();
    }

    @Test
    public void test02_LoginTestNegative() throws InterruptedException {
        logIn("storemanager60","UserUser1232433");
        softAssertion.assertEquals(driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText(),
                                "Invalid user name or password.");
        softAssertion.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
        softAssertion.assertEquals(driver.getTitle(), "Login");

        softAssertion.assertAll();
    }


}
