package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.vytrack.utilities.Variables.*;

public class VytrackUtils {

    public static void waitForUIOverlay(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-mask.shown")));

    }

    public static void logOut(){
        W_USER_MENU.click();
        BrowserUtils.waitForVisibility(W_LOGOUT,2);
        W_LOGOUT.click();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleIs("Login"));
    }


}
