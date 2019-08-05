package com.vytrack.tests.components.activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static com.vytrack.utilities.BrowserUtils.*;
import static com.vytrack.utilities.VytrackUtils.*;

public class DailyRepeatTests extends TestBase {

SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void goToCalendarEvents() {
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
        calendarEventsPage.selectMenuOption("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent.click();
        waitForUIOverlay();
        selectCheckBox(calendarEventsPage.repeatCheckBox,true);
        waitForPageToLoad(5);
    }

    @Test
    public void test01_RepeatEverySummary() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        Select repeatDropDownList = new Select(calendarEventsPage.repeatDropDown);
        softAssert.assertEquals(repeatDropDownList.getFirstSelectedOption().getText(), "Daily");
        softAssert.assertEquals(calendarEventsPage.repeatEveryInput.getAttribute("value"), "1");
        softAssert.assertEquals(calendarEventsPage.summaryMessage.getText(), "Summary:\n" +
                "Daily every 1 day");

        calendarEventsPage.weekDayRadio.click();
        waitForPageToLoad(2);
        softAssert.assertFalse(calendarEventsPage.repeatEveryInput.isEnabled());
        softAssert.assertFalse(calendarEventsPage.repeatEveryRadio.isSelected());
        softAssert.assertEquals(calendarEventsPage.summaryMessage.getText(), "Summary:\n" +
                "Daily, every weekday");

        softAssert.assertAll();
    }

    @Test
    public void test02_RepeatEveryDefaultValues() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        softAssert.assertTrue(calendarEventsPage.repeatEveryRadio.isSelected());
        softAssert.assertEquals(calendarEventsPage.repeatEveryInput.getAttribute("value"), "1");
        softAssert.assertEquals(calendarEventsPage.summaryMessage.getText(), "Summary:\n" +
                "Daily every 1 day");

        softAssert.assertAll();
    }

    @Test
    public void test03_RepeatEveryDayErrorMessages() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        doubleClick(calendarEventsPage.repeatEveryInput);
        calendarEventsPage.repeatEveryInput.sendKeys("0" + Keys.ENTER);
        softAssert.assertEquals(calendarEventsPage.daysAlertMessage.getText(), "The value have not to be less than 1.");

        doubleClick(calendarEventsPage.repeatEveryInput);
        calendarEventsPage.repeatEveryInput.sendKeys("100" + Keys.ENTER);
        softAssert.assertEquals(calendarEventsPage.daysAlertMessage.getText(), "The value have not to be more than 99.");

        Random random = new Random();
        int value = random.nextInt(99) + 1;
        doubleClick(calendarEventsPage.repeatEveryInput);
        calendarEventsPage.repeatEveryInput.sendKeys("" + value);
        softAssert.assertFalse(calendarEventsPage.daysAlertMessage.isDisplayed());

        softAssert.assertAll();

    }

    @Test
    public void test04_RepeatEveryDayFunctionality() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int value = random.nextInt(99) + 1;
            doubleClick(calendarEventsPage.repeatEveryInput);
            calendarEventsPage.repeatEveryInput.sendKeys("" + value);
            calendarEventsPage.repeatEveryRadio.click();
            Assert.assertEquals(calendarEventsPage.summaryMessage.getText(), "Summary:\n" +
                    "Daily every " + value + " days");
        }
    }

    @Test
    public void test05_BlankFields() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.repeatEveryInput.clear();
        calendarEventsPage.repeatEveryInput.click();

        softAssert.assertEquals(calendarEventsPage.daysAlertMessage.getText(),"This value should not be blank.");

        calendarEventsPage.repeatEveryInput.sendKeys("5"+Keys.ENTER);

        softAssert.assertFalse(calendarEventsPage.daysAlertMessage.isDisplayed());

        calendarEventsPage.afterOccurrencesInput.click();
        calendarEventsPage.afterOccurrencesInput.clear();
        calendarEventsPage.afterOccurrencesInput.click();
        calendarEventsPage.repeatEveryInput.click();

        softAssert.assertEquals(calendarEventsPage.occurrencesAlertMessage.getText(), "This value should not be blank.");
        calendarEventsPage.afterOccurrencesInput.sendKeys("5");

        softAssert.assertFalse(calendarEventsPage.occurrencesAlertMessage.isDisplayed());

        softAssert.assertAll();

    }

    @Test
    public void test06_EndsErrorMessages() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.afterOccurrencesInput.click();
        calendarEventsPage.afterOccurrencesInput.clear();
        calendarEventsPage.afterOccurrencesInput.sendKeys("0"+Keys.ENTER);
        //waitFor(1);
        softAssert.assertEquals(calendarEventsPage.occurrencesAlertMessage.getText(), "The value have not to be less than 1.");
        calendarEventsPage.afterOccurrencesInput.clear();
        calendarEventsPage.afterOccurrencesInput.sendKeys("1000"+Keys.ENTER);

        softAssert.assertEquals(calendarEventsPage.occurrencesAlertMessage.getText(), "The value have not to be more than 999.");
        Random random = new Random();
        int value = random.nextInt(999) + 1;
        calendarEventsPage.afterOccurrencesInput.clear();
        calendarEventsPage.afterOccurrencesInput.sendKeys(""+value+Keys.ENTER);

        softAssert.assertFalse(calendarEventsPage.occurrencesAlertMessage.isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void test07_EndsFunctionality() {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.afterOccurrencesInput.click();
        for (int i = 1; i < 2; i++) {
            Random random = new Random();
            int value = random.nextInt(999) + 1;
            calendarEventsPage.afterOccurrencesInput.clear();
            calendarEventsPage.afterOccurrencesInput.sendKeys(""+value+Keys.ENTER);
            Assert.assertEquals(calendarEventsPage.summaryMessage.getText(), "Summary:\n" +
                    "Daily every 1 day, end after "+value+" occurrences");
        }

    }
}
