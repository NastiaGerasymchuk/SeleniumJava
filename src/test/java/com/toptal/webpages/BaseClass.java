package com.toptal.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class BaseClass {
    private WebDriver driver;
    public BaseClass(WebDriver driver){
        this.driver=driver;
    }
    public void SendKeys(Keys value, WebElement webElement){
        webElement.sendKeys(value);
    }
    public void InputText(String value, WebElement webElement){
        webElement.sendKeys(value);
    }
    public void Click(WebElement webElement){
        webElement.click();
    }
    public String getValue(WebElement webElement){
       return webElement.getAttribute("value");
    }
}
