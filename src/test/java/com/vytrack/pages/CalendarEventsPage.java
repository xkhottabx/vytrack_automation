package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalendarEventsPage extends NavigationBar {

    public CalendarEventsPage() {
        super();
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[1]")
    public WebElement startDateInput;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement endDateInput;

    @FindBy(xpath = "(//input[@placeholder='time'])[1]")
    public WebElement startTimeInput;

    @FindBy(xpath = "(//input[@placeholder='time'])[2]")
    public WebElement endTimeInput;

    @FindBy(css = "input[data-name='recurrence-repeat']")
    public WebElement repeatCheckBox;

    @FindBy(xpath = "//select[@class='recurrence-repeats__select']")
    public WebElement repeatDropDown;

    @FindBy(xpath = "(//input[@data-related-field='interval'])[1]")
    public WebElement repeatEveryInput;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement repeatEveryRadio;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekDayRadio;

    @FindBy(css = "div[class='control-group recurrence-summary alert-info']")
    public WebElement summaryMessage;

    @FindBy(xpath = "//span[text()='day(s)']/../following-sibling::span")
    public WebElement daysAlertMessage;

    @FindBy(css = "input[data-related-field='occurrences']")
    public WebElement afterOccurrencesInput;

    @FindBy(xpath = "(//input[@type='checkbox'])[20]")
    public WebElement occurrencesAlertMessage;

















}