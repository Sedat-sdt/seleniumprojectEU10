package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoad {
    //TC#4 : Dynamically Loaded Page Elements 7
    //Note: Follow POM
    @Test

    public void dynamicLoad7PageTest() {

        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        //creating the wait object to be able to create certain condition to wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the wait object to create our expected condition

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //create object of DynamicLoad7Page to reach and assert web element

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicLoad7Page.doneMessageText.isDisplayed());

        BrowserUtils.sleep(2);


        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.aFewMomentsLaterImage.isDisplayed());


        Driver.closeDriver();

    }

    @Test
    public void dynamically_Loaded_Page_ElementsTest(){
        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        DynamicLoad1Page dynamicLoad1Page=new DynamicLoad1Page();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

        dynamicLoad1Page.startButton.click();

        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed

        Assert.assertTrue(dynamicLoad1Page.inputUserName.isDisplayed());

        //5. Enter username: tomsmith

        dynamicLoad1Page.inputUserName.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword

        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicLoad1Page.submitBtn.click();

        //8. Assert “Your password is invalid!” text is displayed.

        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());


        //Note: Follow POM Design Pattern
    }




}