package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;


    @BeforeMethod
    public void setupMethod(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage=new DynamicControlsPage();
    }

    @Test
    public void removeBtnTest(){

        //3- Click to “Remove” button

        dynamicControlsPage.removeBtn.click();

        //4- Wait until “loading bar disappears”
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            //Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());


    }

    @Test
    public void enableBtnTest(){

        //3- Click to “Enable” button

        dynamicControlsPage.enableBtn.click();
        //4- Wait until “loading bar disappears”

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.

        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));
    }

}
