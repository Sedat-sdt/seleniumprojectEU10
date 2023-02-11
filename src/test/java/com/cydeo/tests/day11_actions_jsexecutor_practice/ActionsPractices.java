package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test

    public void task_4_and_5_test(){
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/

        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeAsyncScript()


        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions=new Actions(Driver.getDriver());

        //WebElement poweredByCydeoLink=Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement poweredByCydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.moveToElement(poweredByCydeoLink).perform();
        BrowserUtils.sleep(2);



        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button

        actions.sendKeys(Keys.PAGE_UP).perform();
        BrowserUtils.sleep(2);




    }
}
