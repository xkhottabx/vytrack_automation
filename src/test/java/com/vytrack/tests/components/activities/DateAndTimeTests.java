package com.vytrack.tests.components.activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.vytrack.utilities.BrowserUtils.*;
import static com.vytrack.utilities.DateTimeUtils.*;
import static com.vytrack.utilities.VytrackUtils.*;

public class DateAndTimeTests extends TestBase {

    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void goToCalendarEvents(){
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent.click();
        waitForUIOverlay();
    }

    @Test
    public void test01_EndDateAutoAdjust() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.startDateInput.clear();
        calendarEventsPage.startDateInput.sendKeys(localDatePlus(2));
        waitFor(1);
        softAssert.assertEquals(calendarEventsPage.startDateInput.getAttribute("value"),
                                calendarEventsPage.endDateInput.getAttribute("value"));

        calendarEventsPage.startDateInput.clear();
        calendarEventsPage.startDateInput.sendKeys(localDateNow()+Keys.ENTER);
        waitFor(1);
        softAssert.assertEquals(calendarEventsPage.endDateInput.getAttribute("value"),
                localDateNow());

        softAssert.assertAll();

    }


    @Test
    public void test02_EndTimeAutoAdjust() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.startTimeInput.clear();
        calendarEventsPage.startTimeInput.sendKeys(localTimePlus(2,0)+ Keys.ENTER);
        waitFor(1);
        Assert.assertEquals(calendarEventsPage.endTimeInput.getAttribute("value"),
                localTimePlus(3,0));

    }


    @Test
    public void test03_EndDateTimeAutoAdjust(){
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.startTimeInput.clear();
        calendarEventsPage.startTimeInput.sendKeys("11:30 PM"+ Keys.ENTER);
        waitFor(1);
        softAssert.assertEquals(calendarEventsPage.endTimeInput.getAttribute("value"), "12:30 AM");//FAILED
        softAssert.assertEquals(calendarEventsPage.endDateInput.getAttribute("value"), localDatePlus(1));//FAILED
        softAssert.assertAll();

    }




}
