package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class T5 {
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/windows");
    }
    @Test
    public void windowTest(){

    String mainHandle= Driver.getDriver().getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        String expectedTitle="Windows";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("actualTitle1 = " + actualTitle);

        WebElement clickHereBtn = Driver.getDriver().findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String each : windowHandles) {
          Driver.getDriver().switchTo().window(each);
            System.out.println("Current Title = " + Driver.getDriver().getTitle());

        }

        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window");
        System.out.println("after clicking = " + Driver.getDriver().getWindowHandle());

        System.out.println("window(mainHandle).getTitle() = " + Driver.getDriver().switchTo().window(mainHandle).getTitle());

    }


}
