package com.cydeo.tests.day7_WebTables_Utilities_JavaFaker;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3 {

    @Test
    public void crmTest(){
        Driver.getDriver().get("https://login1.nextbasecrm.com/");

        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameInput.sendKeys("helpdesk1@cybertekschool.com");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));

        passwordInput.sendKeys("UserUser");

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");



    }




}
