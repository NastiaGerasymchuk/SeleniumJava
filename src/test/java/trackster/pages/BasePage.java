package trackster.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trackster.data.BrowserConfigure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
   protected WebDriver driver;
   protected WebDriverWait wait;

   public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(BrowserConfigure.SECONDS_WANTINGS));
        PageFactory.initElements(this.driver, this);
    }
    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
    protected String getAttribute(WebElement webElement, String attribute){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);

    }
    protected String getText(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
    protected   void sendKeys(WebElement webElement ,String number){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(number);

    }


}
