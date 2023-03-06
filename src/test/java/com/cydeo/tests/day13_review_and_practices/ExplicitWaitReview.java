package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPageReview;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitReview {
DynamicControlsPageReview dynamicControlsPageReview;
    //TC #2: Explicit wait practice
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/dynamic_controls
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

    dynamicControlsPageReview=new DynamicControlsPageReview();
}
@Test
    public void removeBtnTest(){

        //3- Click to “Remove” button

        dynamicControlsPageReview.removeButton.click();
        //4- Wait until “loading bar disappears”

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPageReview.loadingBarr));
        //5- Verify:
    //a. Checkbox is not displayed
    try {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertFalse(dynamicControlsPageReview.checkBox.isDisplayed());
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPageReview.messageText.isDisplayed());
    }catch (NoSuchElementException n){
        Assert.assertTrue(true);
    }


    }

}
