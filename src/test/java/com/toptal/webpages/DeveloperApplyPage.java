package com.toptal.webpages;

import com.toptal.Programmer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.management.relation.Role;

public class DeveloperApplyPage extends BaseClass {
    @FindBy(css = ".has-default_value")
    WebElement def;
    @FindBy(css = ".is-active > .custom_select-options_item_title")
    WebElement role;
    @FindBy(css = ".custom_select > .input:nth-child(2)")
    WebElement sel;
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
    @FindBy(css = "#top > div.cookie_banner-container > div > div.cookie_banner-buttons_container > a")
    private WebElement cookie;
    public DeveloperApplyPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public DeveloperApplyPage setRole(){
        def.click();
        int setProgrammer=Programmer.PROJECT_MANAGER.getProgrammerCode();
       for (int i=0;i<setProgrammer;i++ ){
           SendKeys(Keys.ARROW_DOWN,def);
       }
        SendKeys(Keys.ENTER,def);
       return this;
    }
    public DeveloperApplyPage setFullName(String text){
        InputText(text,full_name);
        return this;
    }
    public DeveloperApplyPage setEmail(String text){
        InputText(text,email);
        return this;
    }
    public DeveloperApplyPage setPassword(String text){
        InputText(text,password);
        return this;
    }
    public DeveloperApplyPage confirmPassword(){
        InputText(getValue(password),confirm_password);
        return this;
    }
    public DeveloperApplyPage confirmCookie(){
        Click(cookie);
        return this;
    }
    public void Apply(){
        Click(btnApply);
    }


}
