package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2 {
    @Test
    public void uploadTest(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        String path="C:\\Users\\Sony Vaio\\Desktop\\sude\\ataturk_odev_kapagi_(4).doc";


        WebElement fileLoadInput = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));

        BrowserUtils.sleep(2);

        fileLoadInput.sendKeys(path);

        WebElement uploadBtn=Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadBtn.click();

        WebElement uploadMessage=Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(uploadMessage.isDisplayed());


    }
}
