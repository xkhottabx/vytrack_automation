package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Variables {
   // public static WebDriver driver;
   public static final String LOGIN_PAGE_URL="http://qa3.vytrack.com/user/login";
    public static final String PAGE_CLASS_NAME ="oro-subtitle";//name of the Page
    public static final String USER_MENU_ID="user-menu";
    public static final String INVALID_PASSWORD="UserUser1232433";
    public static final String LOGOUT="(//li[@class='last'])[3]";
    public static final WebElement W_USER_MENU =Driver.get().findElement(By.id(USER_MENU_ID));
    public static final WebElement W_LOGOUT =Driver.get().findElement(By.xpath(LOGOUT));

}
