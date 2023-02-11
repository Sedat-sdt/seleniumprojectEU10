package com.cydeo.tests.tasks;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

    @Test
    public void javaScriptExecutorTest(){

        //C #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        //b. 750 pixels up 10 times

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();



        for (int i = 1; i <=10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        for (int i = 1; i <=10 ; i++) {
            BrowserUtils.sleep(1);
            //js.executeScript("window.scrollBy(0,-750)");
            js.executeScript("window." +
                    "");
        }

        //JavaScript method to use : window.scrollBy(0,0)


    }
}
