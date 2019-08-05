package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.vytrack.utilities.VytrackUtils.waitForUIOverlay;


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name="_username")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy (id = "_submit")
    public WebElement submit;

    @FindBy (css = "div[class='alert alert-error']")
    public WebElement invalidCredentials;


    public void login(String usernameStr, String passwordStr){
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();
        waitForUIOverlay();

    }

}
