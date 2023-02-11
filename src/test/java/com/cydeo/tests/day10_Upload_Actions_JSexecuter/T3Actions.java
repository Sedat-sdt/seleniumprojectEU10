package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3Actions {

    @Test
    public void hoveringTest(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

     Actions actions=new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        actions.moveToElement(img1).perform();
        BrowserUtils.sleep(2);

        WebElement user1=Driver.getDriver().findElement(By.xpath("(//h5)[1]"));
        Assert.assertTrue(user1.isDisplayed());


    }

}
