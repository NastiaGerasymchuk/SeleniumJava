package com.toptal.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="http://ttrackster.herokuapp.com/";

    //Locators

    //Apply as Developer Button

    @FindBy(css = "#nav > div > ul > li:nth-child(1) > a")
    private WebElement developerApplyButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public DeveloperPortralPage clickOnDeveloperApplyButton(){

        developerApplyButton.click();
        return new DeveloperPortralPage(driver);
    }
}
