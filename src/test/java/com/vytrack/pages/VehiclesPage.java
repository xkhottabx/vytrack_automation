package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehiclesPage extends NavigationBar {

    public VehiclesPage() {
        super();
    }

    @FindBy(css = "table[class='grid table-hover table table-bordered table-condensed']")
    public WebElement carsTable;

    public int getRowCount() {
        return Driver.get().findElements
                (By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tr")).size();
    }

    public int getColCount() {
        return Driver.get().findElements
                (By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//th")).size();
    }

    public List<WebElement> getHeaders() {
        return Driver.get().findElements
                (By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/thead"));
    }


    public void clickOnHeader(String header){
        Driver.get().findElement(By.xpath("//th[.='"+header+"']")).click();
    }


    public List<WebElement> getColumn(String column){
        String xpath = "//td[@data-column-label='"+column+"']";
        return Driver.get().findElements(By.xpath(xpath));
    }

    public void selectAllCheckboxes(){
        Driver.get().findElement
                (By.xpath("(//input[@type='checkbox'])[20]")).click();//ASK
    }

    public List<WebElement> getCheckboxColumn(){
        return Driver.get().findElements
                (By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tr/td[1]"));
    }

   public boolean checkboxesAreSelected(){
       List<WebElement> checkboxes=Driver.get().findElements
               (By.xpath("//input[@tabindex]"));
       for (WebElement checkbox:checkboxes) {
           if (!checkbox.isSelected()){
               return  false;
           }
       }
      return  true;
   }

   public List<String> getAscendingSortedColumn(List<String> column){
       Collections.sort(column);
       return column;
   }

    public List<String> getDescendingSortedColumn(List<String> column){
        column.sort(Comparator.reverseOrder());
        return column;
    }

}
