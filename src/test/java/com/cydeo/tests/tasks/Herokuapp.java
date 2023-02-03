package com.cydeo.tests.tasks;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Herokuapp {

    @BeforeMethod
    public void heroAppMethod(){
        Driver.getDriver().get("http://the-internet.herokuapp.com/");
    }
    @Test
    public void addRemoveElementsTest(){

        WebElement addElementsLink=Driver.getDriver().findElement(By.linkText("Add/Remove Elements"));
        BrowserUtils.sleep(2);
        addElementsLink.click();

        BrowserUtils.sleep(2);

        WebElement addElementBtn= Driver.getDriver().findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();

        WebElement deleteBtn=Driver.getDriver().findElement(By.xpath("//button[@class='added-manually']"));

        Assert.assertTrue(deleteBtn.isDisplayed());

        BrowserUtils.sleep(2);

        deleteBtn.click();
    }

    @Test

    public void loginTEST() {
Driver.getDriver().get("http://admin:admin@the-internet.herokuapp.com/basic_auth");






    }
       /* WebElement basicAuthLink=Driver.getDriver().findElement(By.linkText("Basic Auth"));
        basicAuthLink.click();
        BrowserUtils.sleep(2);

        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement()

       /* Alert alert= Driver.getDriver().switchTo().alert();
        BrowserUtils.sleep(2);
        alert.sendKeys("admin"+ Keys.TAB);
        BrowserUtils.sleep(2);
        alert.sendKeys("admin"+Keys.ENTER);
*/
   @Test

   public void brokenImagesTEST() {

       WebElement brokenImagesLink = Driver.getDriver().findElement(By.linkText("Broken Images"));
       brokenImagesLink.click();
       BrowserUtils.sleep(2);

       WebElement avatar3=Driver.getDriver().findElement(By.xpath("//img[@src='img/avatar-blank.jpg']"));
       Assert.assertTrue(avatar3.isDisplayed());

       BrowserUtils.sleep(2);

       WebElement avatar2=Driver.getDriver().findElement(By.xpath("//img[@src='hjkl.jpg']"));
       Assert.assertTrue(avatar2.isDisplayed());

       WebElement avatar1=Driver.getDriver().findElement(By.xpath("//img[@src='asdf.jpg']"));
       Assert.assertTrue(avatar1.isEnabled());

   }

   @Test
    public void checkBoxesTest(){
        WebElement checkBoxesLink=Driver.getDriver().findElement(By.linkText("Checkboxes"));
        BrowserUtils.sleep(2);
        checkBoxesLink.click();

        WebElement checkBox1=Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("checkBox1.isSelected() = false(expected)" + checkBox1.isSelected());

       checkBox1.click();
       System.out.println("checkBox1.isSelected() = true(expected)" + checkBox1.isSelected());

       BrowserUtils.sleep(2);



        WebElement checkBox2=Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));
        System.out.println("checkBox1.isSelected() = true(expected)" + checkBox2.isSelected());



        checkBox2.click();
        System.out.println("checkBox1.isSelected() = false(expected)" + checkBox2.isSelected());

        BrowserUtils.sleep(2);

   }

   @Test
    public void contextMenuTest(){

       Actions actions=new Actions(Driver.getDriver());
       BrowserUtils.sleep(2);

      WebElement contextBox=Driver.getDriver().findElement(By.xpath("//div[@id='content']/div/div"));
       BrowserUtils.sleep(2);
      actions.moveToElement(contextBox).contextClick();
      //actions.contextClick(contextBox).perform();




   }







}



