package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.vytrack.utilities.Variables.*;
import static com.vytrack.utilities.VytrackUtils.logOut;
import static com.vytrack.utilities.VytrackUtils.waitForUIOverlay;

public class LoginTest extends TestBase {

    SoftAssert softAssertion = new SoftAssert();

    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test01_LoginTestPositive() {
        LoginPage loginPage=new LoginPage();

        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));
        waitForUIOverlay();
        softAssertion.assertEquals(driver.findElement(By.id(USER_MENU_ID)).getText(), "Mark Gusikowski");
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        logOut();
        loginPage.login(ConfigurationReader.get("salesmanager_username"), ConfigurationReader.get("salesmanager_password"));
        waitForUIOverlay();
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        softAssertion.assertFalse(driver.findElement(By.id(USER_MENU_ID)).getText().equals("Mark Gusikowski"));
        logOut();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
        waitForUIOverlay();
        softAssertion.assertEquals(driver.getTitle(), "Dashboard");
        softAssertion.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "Quick Launchpad");
        softAssertion.assertFalse(driver.findElement(By.id(USER_MENU_ID)).getText().equals("Roselyn Little"));

        softAssertion.assertAll();
    }

    @Test
    public void test02_LoginTestNegative() {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), INVALID_PASSWORD);
        softAssertion.assertEquals(loginPage.invalidCredentials.getText(),
                                "Invalid user name or password.");
        softAssertion.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
        softAssertion.assertEquals(driver.getTitle(), "Login");

        softAssertion.assertAll();
    }


}
