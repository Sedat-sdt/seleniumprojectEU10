package com.cydeo.tests.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T_Evraka {


    @Test
    public void test1() {

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512" + Keys.ENTER);


        driver.findElement(By.xpath("//div[@data-component-id='17']")).click();

        String brand = driver.findElement(By.xpath("//tr[@class='a-spacing-small po-model_name']/td[2]//span")).getText();
        String size = "size: " + driver.findElement(By.xpath("//div[@id='variation_size_name']/div/span")).getText();


        String color = "color: " + driver.findElement(By.xpath("//div[@id='variation_color_name']/div/span")).getText();


        String stockText = "Stock: " + driver.findElement(By.xpath("//div[@id='availabilityInsideBuyBox_feature_div']//span")).getText();

        Select select = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        String quantity = select.getFirstSelectedOption().getText();

        String price = "price:" + driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div//span[@class='a-price-whole']")).getText();
        String price2 = "," + driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div//span[@class='a-price-whole']/following-sibling::span")).getText();
        String price3 = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div//span[@class='a-price-whole']/following-sibling::span[2]")).getText();


        System.out.println(brand.substring(0, 10) + "   " + size + "\n" + color + "  " + price + price2 + price3 + "\n" + stockText);


    }
}
