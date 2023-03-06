package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeBtn;

   // @FindBy(xpath = "//img[@src='/img/ajax-loader.gif']")
    @FindBy(css="div#loading")
    public WebElement loadingBar;

   // @FindBy(xpath = "//input[@type='checkbox']")
    @FindBy(css="input[label='blah']")
    public WebElement checkBox;

    @FindBy(id="message")
    public WebElement message;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableBtn;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;





}
