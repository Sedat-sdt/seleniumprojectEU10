package com.cydeo.tests.tasks;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Evreka {

    @Test
    public void evrekaTest(){
        Driver.getDriver().get("https://amazon.com.tr");

        WebElement cookiesBtn=Driver.getDriver().findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cookiesBtn.click();

        BrowserUtils.sleep(2);

        WebElement searchInputBox=Driver.getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchInputBox.sendKeys("iPhone 13 512"+ Keys.ENTER);

        WebElement firstIphone=Driver.getDriver().findElement(By.xpath("//img[@data-image-index='1']"));
        firstIphone.click();

        WebElement yıldızIşığıBtn=Driver.getDriver().findElement(By.xpath("//img[@alt='Yıldız Işığı']"));
        yıldızIşığıBtn.click();

        WebElement model=Driver.getDriver().findElement(By.xpath("//*[@id=\"kfs_family_5\"]/a/img"));
        System.out.print(model.getAttribute("alt")+"  ");

        BrowserUtils.sleep(2);

        WebElement size=Driver.getDriver().findElement(By.xpath("//*[@id=\"variation_size_name\"]/div/span"));
        System.out.println("Size:"+size.getText());

        BrowserUtils.sleep(2);

        WebElement color=Driver.getDriver().findElement(By.xpath("//*[@id=\"variation_color_name\"]/div/span"));
        System.out.print("Color:"+color.getText()+" ");

        BrowserUtils.sleep(2);

        /*JavaScriptExecutor js= (JavaScriptExecutor)Driver.getDriver();
        js.*/
        WebElement price=Driver.getDriver().findElement(By.xpath("//*[@id=\"corePrice_feature_div\"]/div/span/span[2]/span[1]"));
        System.out.print("Price:"+price.getText()+",");

        /*WebElement price2=Driver.getDriver().findElement(By.xpath("//*[@id=\"corePrice_feature_div\"]/div/span/span[2]/span[1]/span"));
        System.out.print(price2.getText());*/

        WebElement price3=Driver.getDriver().findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div//span[@class='a-price-whole']/following-sibling::span"));
        System.out.print(price3.getText());


        WebElement price4=Driver.getDriver().findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div//span[@class='a-price-whole']/following-sibling::span[2]"));
        System.out.println(price4.getText());

        BrowserUtils.sleep(2);

        WebElement stock=Driver.getDriver().findElement(By.xpath("//div[@id='availability']/span"));
        System.out.println("Stock:"+stock.getText());


    }
}
