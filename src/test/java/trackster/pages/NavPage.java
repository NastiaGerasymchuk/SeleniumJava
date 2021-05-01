package trackster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import trackster.data.LoginPageLocator;
import trackster.data.NavLocator;

public class NavPage extends BasePage{
@FindBy(css = NavLocator.LOGIN_BTN)
   private WebElement login;

   public  NavPage(WebDriver driver){
       super(driver);
       PageFactory.initElements(driver,this);

   }
   public LoginPage login(){
       click(login);
       return new LoginPage(driver);
   }

}
