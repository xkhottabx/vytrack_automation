package com.vytrack.utilities;

import org.openqa.selenium.By;

import static com.vytrack.utilities.Variables.*;

public class LogInLogOut {



    public static void logIn(String username, String password) throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        Thread.sleep(1000);
        Variables.driver.findElement(By.id("prependedInput")).sendKeys(username);
        Thread.sleep(1000);
        Variables. driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(1000);
        Variables.driver.findElement(By.id("_submit")).click();//LOGIN
        Thread.sleep(6000);
    }

    public static void logOut() throws InterruptedException {
        driver.findElement(By.id("user-menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[5]/a")).click();
        Thread.sleep(2000);
    }

}
