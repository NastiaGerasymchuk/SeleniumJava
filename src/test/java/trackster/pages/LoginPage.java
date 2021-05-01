package trackster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trackster.data.LoginPageLocator;

public class LoginPage extends BasePage{
    @FindBy(id = LoginPageLocator.EMAIL)
    private WebElement email;
    @FindBy(css = LoginPageLocator.GMAIL_BTN)
    private WebElement gmailBtn;
    @FindBy(css = LoginPageLocator.GO_TO_PASSWORD_BTN)
    private WebElement goToPasswordBtn;
    @FindBy(name = LoginPageLocator.PASSWORD)
    private WebElement password;
    @FindBy(css = LoginPageLocator.GO_TO_PAGE)
    private WebElement goToPageBtn;

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void setEmail(String em){
        sendKeys(email,em);
    }
    public LoginPage gmailLogin(){
        click(gmailBtn);
        return this;
    }
    public LoginPage goToPassword(){
        click(goToPasswordBtn);
        return this;
    }
    public LoginPage setPassword(String pass){
        sendKeys(password,pass);
        return this;
    }
    public HomePage goToPage(){
        click(goToPageBtn);
        return new HomePage(driver);
    }
}
