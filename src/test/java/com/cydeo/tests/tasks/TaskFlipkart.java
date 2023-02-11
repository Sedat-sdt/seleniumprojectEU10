package com.cydeo.tests.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TaskFlipkart {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com");

        WebElement loginCloseButton=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        loginCloseButton.click();

        Thread.sleep(3000);
        //Select electronicsButton=new Select(driver.findElement(By.xpath("//div[.='Electronics']//div[2]")));
        Actions electronics= new Actions (driver);


        WebElement electronicsButton=driver.findElement(By.xpath("(//a[@class='_6WOcW9 _3YpNQe'])[4]"));
        Thread.sleep(3000);

        electronics.moveToElement(electronicsButton).perform();
        //Select audioButton=new Select (electronicsButton);


/*
public void pageTest() throws InterruptedException {
        WebElement xButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        xButton.click();
        Actions action = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("(//div[@class='eFQ30H'])[4]"));
        //Creating object of an Actions class
        //Performing the mouse hover action on the target element.
        action.moveToElement(electronics).pause(2000).perform();
        WebElement wiredHeadphones = driver.findElement(By.xpath("(//a[@class='_6WOcW9 _3YpNQe'])[4]"));
        action.moveToElement(wiredHeadphones).click().pause(2000).perform();
        if(driver.getTitle().contains("Headphones")){
            System.out.println("PASS!!");
        }else {
            System.out.println("FAILED!!!");
 */

    }

}
