package com.vytrack.tests.components.fleet;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.vytrack.utilities.BrowserUtils.*;
import static com.vytrack.utilities.VytrackUtils.waitForUIOverlay;

public class VehiclesTests extends TestBase {

    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void goToVehicles() {
        LoginPage loginPage=new LoginPage();
        VehiclesPage vehiclesPage=new VehiclesPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));
        vehiclesPage.selectMenuOption("Fleet", "Vehicles");
        waitForUIOverlay();
    }

    @Test
    public void test01_VerifyDefaultOrderLicensePlate() {
        VehiclesPage vehiclesPage=new VehiclesPage();
        vehiclesPage.clickOnHeader("License Plate");
        waitForUIOverlay();
        List<String> initialColumn=getElementsText(vehiclesPage.getColumn("License Plate"));
        List<String> initialColumnToAscend=getElementsText(vehiclesPage.getColumn("License Plate"));
        List<String> ascendedColumn=vehiclesPage.getAscendingSortedColumn(initialColumnToAscend);

        softAssert.assertEquals(initialColumn, ascendedColumn);

        vehiclesPage.clickOnHeader("License Plate");
        waitForUIOverlay();
        initialColumn=getElementsText(vehiclesPage.getColumn("License Plate"));
        List<String> initialColumnToDescend=getElementsText(vehiclesPage.getColumn("License Plate"));
        List<String> descendedColumn=vehiclesPage.getDescendingSortedColumn(initialColumnToDescend);

        softAssert.assertEquals(initialColumn, descendedColumn);

        softAssert.assertAll();

    }

    @Test
    public void test02_VerifyDefaultOrderDriver() {
        VehiclesPage vehiclesPage=new VehiclesPage();
        vehiclesPage.clickOnHeader("Driver");
        waitForUIOverlay();
        List<String> initialColumn=getElementsText(vehiclesPage.getColumn("Driver"));
        List<String> initialColumnToAscend=getElementsText(vehiclesPage.getColumn("Driver"));
        List<String> ascendedColumn=vehiclesPage.getAscendingSortedColumn(initialColumnToAscend);

        softAssert.assertEquals(initialColumn, ascendedColumn);

        vehiclesPage.clickOnHeader("Driver");
        waitForUIOverlay();
        initialColumn=getElementsText(vehiclesPage.getColumn("Driver"));
        List<String> initialColumnToDescend=getElementsText(vehiclesPage.getColumn("Driver"));
        List<String> descendedColumn=vehiclesPage.getDescendingSortedColumn(initialColumnToDescend);

        softAssert.assertEquals(initialColumn, descendedColumn);

        softAssert.assertAll();
    }


    @Test
    public void test03_VerifyDefaultOrderDriver() {
        VehiclesPage vehiclesPage=new VehiclesPage();
        softAssert.assertFalse(vehiclesPage.checkboxesAreSelected());
        vehiclesPage.selectAllCheckboxes();
        waitForUIOverlay();
        softAssert.assertTrue(vehiclesPage.checkboxesAreSelected());

        softAssert.assertAll();


    }



}
