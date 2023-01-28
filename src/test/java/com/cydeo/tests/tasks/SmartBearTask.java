package com.cydeo.tests.tasks;


import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmartBearTask {

    /*
TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”
*/
    @Test
    public void order_verification(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameInput.sendKeys("Tester");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys("test");

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement viewAllOrdersButton = Driver.getDriver().findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrdersButton.click();

        WebElement susanDate = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//tr[6]//td[5]"));
        String actualSusanDate=susanDate.getText();
        String expectedSusanDate="01/05/2010";
        System.out.println(actualSusanDate);

        Assert.assertEquals(actualSusanDate,expectedSusanDate);

    }



}