package trackster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NavPage extends BasePage{

   public  NavPage(WebDriver driver){
       super(driver);
       PageFactory.initElements(driver,this);

   }
}
