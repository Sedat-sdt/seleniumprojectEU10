package com.cydeo.tests.day7_WebTables_Utilities_JavaFaker;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

public class T1 {

@Test

    public void windowTest(){
    Driver.getDriver().get("https://google.com");

    ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.amazon.com','_blank');");

    Driver.getDriver().get("https://etsy.com");
    Driver.getDriver().get("https://facebook.com");


    Set<String> windowHandles = Driver.getDriver().getWindowHandles();

    for (String eachWindowHandle : windowHandles) {
        Driver.getDriver().switchTo().window(eachWindowHandle);
        System.out.println(Driver.getDriver().getTitle());

    }
    System.out.println("Title() = " + Driver.getDriver().getTitle());

}




}
