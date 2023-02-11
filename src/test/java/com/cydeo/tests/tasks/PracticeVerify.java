package com.cydeo.tests.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PracticeVerify {

    @Test
    public void checkBoxTest(){
        Driver.getDriver().get("http://practice.cydeo.com/");
        Driver.getDriver().findElement(By.linkText("Checkboxes")).click();
    }
}
