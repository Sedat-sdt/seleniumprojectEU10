package com.cydeo.tests.day8_properties_config_reader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_WebTable {

    WebDriver driver;

  @BeforeMethod
  public void setupMethod(){

      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://practice.cydeo.com/web-tables");

  }

  @Test
    public void webTableTest(){

      WebElement bobMartinCell=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));

      System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

      Assert.assertEquals(bobMartinCell.getText(),"Bob Martin");

      WebElement dateOfBob = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='12/31/2021']"));

      //  //table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]

      System.out.println("dateOfBob.getText() = " + dateOfBob.getText());

      Assert.assertEquals(dateOfBob.getText(),"12/31/2021");

      List<WebElement> bobMartinCells = driver.findElements(By.xpath("//table[@class='SampleTable']//tr[7]//td"));

      for (WebElement eachCell : bobMartinCells) {
          System.out.println("eachCell.getText() = " + eachCell.getText());


      }


  }




}
