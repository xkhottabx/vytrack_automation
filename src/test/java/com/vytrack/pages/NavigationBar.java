package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class NavigationBar {

    public NavigationBar(){
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement getTab(String tab) {
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '" + tab + "')]";
        return Driver.get().findElement(By.xpath(tabXpath));
    }

    public WebElement getModule(String module) {
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '" + module + "')]";
        return Driver.get().findElement(By.xpath(moduleXpath));
    }

    public void selectMenuOption(String tab, String module) {
        WebElement tabEl = getTab(tab);
        BrowserUtils.hover(tabEl);

        WebElement moduleEl = getModule(module);
        BrowserUtils.waitForClickablility(moduleEl, 5).click();
        VytrackUtils.waitForUIOverlay();
//        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
//
//        wait.until(ExpectedConditions.titleContains(module));

    }
}
