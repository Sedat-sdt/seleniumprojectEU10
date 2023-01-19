package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_ScrollPractice {

    @Test
    public  void scrollTest(){

    //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/

        Driver.getDriver().get("https://practice.cydeo.com/");


        //3- Scroll down to “Powered by CYDEO”
         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeAsyncScript()


        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions=new Actions(Driver.getDriver());

        WebElement poweredByCydeoText=Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));

        actions.moveToElement(poweredByCydeoText).perform();




        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button







    }
}
