package com.toptal.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperPortralPage {
    private WebDriver driver;
    @FindBy(className = "modal-content-header")
    private WebElement heading;
    @FindBy(id = "talent_create_applicant_full_name")
    private WebElement full_name;
    @FindBy(id = "talent_create_applicant_email")
    private WebElement email;
    @FindBy(id = "talent_create_applicant_password")
    private WebElement password;
    @FindBy(id = "talent_create_applicant_password_confirmation")
    private WebElement confirm_password;
    @FindBy(id="save_new_talent_create_applicant")
    private WebElement btnApply;
    public DeveloperPortralPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isPageOpened(){
        return heading.getText().toString().contains("Apply to Join");
    }

}
