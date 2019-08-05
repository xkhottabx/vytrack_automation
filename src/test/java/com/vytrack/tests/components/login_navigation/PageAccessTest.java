package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.vytrack.utilities.Variables.*;

public class PageAccessTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("url"));
    }


    @Test
    public void test01_VehicleContractsTestStoreManager() {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));
        dashboardPage.selectMenuOption("Fleet", "Vehicle Contracts");
        Assert.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Vehicle Contract");

    }

    @Test
    public void test02_VehicleContractsTestSalesManager() {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        loginPage.login(ConfigurationReader.get("salesmanager_username"), ConfigurationReader.get("salesmanager_password"));
        dashboardPage.selectMenuOption("Fleet", "Vehicle Contracts");
        Assert.assertEquals(driver.findElement(By.className(PAGE_CLASS_NAME)).getText(), "All Vehicle Contract");

    }

    @Test
    public void test03_VehicleContractsTestTruckDriver() {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
        dashboardPage.selectMenuOption("Fleet", "Vehicle Contracts");

        Assert.assertEquals(dashboardPage.errorMessageDriverUser.getText(),
                "×\n" +
                        "You do not have permission to perform this action.");

    }




}
