package com.cydeo.tests.tasks;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CydeoPracticeTest {

    WebDriver driver;

   @BeforeMethod
   public void setUpMethod(){

       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://practice.cydeo.com");

       //With WebDriverFactory class

     /* WebDriver driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://practice.cydeo.com");*/


       //With Driver util class
       //Driver.getDriver().get("https://practice.cydeo.com");


   }
  /* @AfterMethod
   public void tearDownMethod(){
       driver.close();

   }*/

    @Test
    public void homeLinkTextTest(){

        WebElement homeLink=driver.findElement(By.linkText("Home"));
        homeLink.click();

        String expectedTitle="Practice";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void urlTest(){
        WebElement homeLink=driver.findElement(By.linkText("Home"));
        homeLink.click();

        String expectedUrl="https://practice.cydeo.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        System.out.println("actualUrl = " + actualUrl);
    }


    @Test
    public  void searchBoxTest(){
        driver.navigate().to("https://google.com");
        WebElement googleSearchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        String expectedTitle="apple";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle,"titles are not same!!!");

        System.out.println("actualTitle = " + actualTitle);

    }
    @Test
    public void libraryVerificationTest(){
        driver.get("https://library2.cybertekschool.com/login.html");

       WebElement emailAddressInput= driver.findElement(By.xpath("//input[@type='email']"));
       emailAddressInput.sendKeys("incorrect@email.com");

       WebElement passwordInput= driver.findElement(By.xpath("//input[@type='password']"));
       passwordInput.sendKeys("incorrect password");

       WebElement signInBtn=driver.findElement(By.xpath("//button[@type='submit']"));
       signInBtn.click();

       WebElement messageText=driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        Assert.assertTrue(messageText.isDisplayed());

    }

    @Test

    public void getText_getAttribute_MethodsTest(){

       driver.findElement(By.linkText("Registration Form")).click();

    WebElement headerText=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/h2"));
    String expectedHeaderText="Registration form";
    String actualHeaderText=headerText.getText();
    Assert.assertEquals(expectedHeaderText,actualHeaderText);

    WebElement firstNameInput= driver.findElement(By.xpath("//input[@name='firstname']"));
    String expectedPlaceHolderValue="first name",
            actualPlaceHolderValue=firstNameInput.getAttribute("placeholder");
    Assert.assertEquals(expectedPlaceHolderValue,actualPlaceHolderValue);

    }

@Test
    public void facebookTitleVerificationTest(){

        /*WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);*/

    Driver.getDriver().navigate().to("https://www.facebook.com");

    String expectedTitle="Facebook - Log In or Sign Up";
    String actualTitle=Driver.getDriver().getTitle();
    //Assert.assertEquals(expectedTitle,actualTitle);

    WebElement userNameInput=Driver.getDriver().findElement(By.xpath("//input[@id='email']"));
    userNameInput.sendKeys("incorrect");
    BrowserUtils.sleep(2);
    WebElement passwordInput=Driver.getDriver().findElement(By.xpath("//input[@id='pass']"));
    passwordInput.sendKeys("incorrect");

    BrowserUtils.sleep(2);

    WebElement logInBtn=Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
    logInBtn.click();

    Assert.assertEquals(Driver.getDriver().getTitle(),"Log into Facebook");


}

@Test
    public void nextBaseCRMTest(){
        Driver.getDriver().get("https://login1.nextbasecrm.com/");
    WebElement loginInput = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
    loginInput.sendKeys("incorrect");

    WebElement passwordBtn = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
    passwordBtn.sendKeys("incorrect");

    WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
    loginBtn.click();

    WebElement errorText = Driver.getDriver().findElement(By.xpath("//*[@id=\"login-popup\"]/div[2]"));

    String actualText=errorText.getText();
    String expectedText="Incorrect login or password";
    Assert.assertEquals(expectedText,actualText);


}

@Test

    public void getText_getAttributeTest(){

    Driver.getDriver().get("https://login1.nextbasecrm.com/");

    WebElement rememberText = Driver.getDriver().findElement(By.xpath("//label[@class='login-item-checkbox-label']"));

    String actualRememberMeText=rememberText.getText();
    String expectedRememberMeText="Remember me on this computer";
    Assert.assertEquals(expectedRememberMeText,actualRememberMeText);
/*
    WebElement forgotText = Driver.getDriver().findElement(By.xpath("//a[@class='login-link-forgot-pass']"));

    String actualText=forgotText.getText();
    String expectedText="Forgot your password?";
    Assert.assertEquals(expectedText,actualText);*/

  /*  WebElement forgotLink = Driver.getDriver().findElement(By.xpath("//a[@class='login-link-forgot-pass']"));

    String actualForgotLinkAttribute = forgotLink.getAttribute("href");
    String expectedForgotLinkAttribute="forgot_password=yes";
    Assert.assertEquals(expectedForgotLinkAttribute,actualForgotLinkAttribute);*/


    WebElement loginBtn=Driver.getDriver().findElement(By.cssSelector("input[value='Log In']"));
    String actualBtnText = loginBtn.getAttribute("value");
    String expectedBtnText="Log In";

    Assert.assertEquals(actualBtnText,expectedBtnText);


}

@Test
    public void findElementsTest(){

        Driver.getDriver().get("https://practice.cydeo.com/abtest");


    List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
    System.out.println("links.size() = " + links.size());

    for (WebElement eachLink : links) {
        System.out.println("eachLink.getText() = " + eachLink.getText());

        System.out.println("eachLink.getAttribute(\"href\") = " + eachLink.getAttribute("href"));
    }


}

@Test
    public void checkBoxesTest(){

   Driver.getDriver().get("http://practice.cydeo.com/checkboxes");


    WebElement box1 = Driver.getDriver().findElement(By.xpath("//*[@id=\"box1\"]"));
    box1.isSelected();
    box1.click();
    box1.isSelected();


}

@Test
    public void RadioBtnTest(){
    WebElement radio_buttons = Driver.getDriver().findElement(By.linkText("Radio Buttons"));
    BrowserUtils.sleep(3);
    radio_buttons.click();

}

}
