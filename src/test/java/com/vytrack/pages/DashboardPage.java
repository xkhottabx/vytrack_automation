package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends NavigationBar {
    public DashboardPage() {
      super();
    }


    //error message, when driver user is trying to access Vehicle Contracts page
    @FindBy (xpath = "(//div[@class='alert alert-error fade in top-messages '])[2]")
    public WebElement errorMessageDriverUser;



}
