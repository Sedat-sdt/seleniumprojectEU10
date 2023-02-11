package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class T4_ScrollPractice {

    @Test
    public  void scrollTest(){

    //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/

        Driver.getDriver().get("https://practice.cydeo.com/");


        //3- Scroll down to “Powered by CYDEO”
         //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeAsyncScript()


        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions=new Actions(Driver.getDriver());

        WebElement poweredByCydeoText=Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));

        actions.moveToElement(poweredByCydeoText).perform();

        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));
        actions.moveToElement(cydeoLink).perform();
        cydeoLink.click();

        String mainWindow= Driver.getDriver().getWindowHandle();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

        }

        System.out.println("after for loop getTitle() = " + Driver.getDriver().getTitle());

        Driver.getDriver().switchTo().window(mainWindow);

        System.out.println("after switching main window getTitle() = " + Driver.getDriver().getTitle());

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));

        BrowserUtils.sleep(2);

        //actions.moveToElement(homeLink).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button







    }
}
