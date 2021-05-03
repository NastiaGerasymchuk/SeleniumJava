package trackster.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trackster.data.AboutTrackerLocator;
import trackster.data.BrowserConfigure;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
   protected WebDriver driver;
   protected WebDriverWait wait;

   public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(BrowserConfigure.SECONDS_WANTINGS));
        PageFactory.initElements(this.driver, this);
    }
    private void waitForElementToBeDisplayed(WebElement element) {
        ExpectedCondition<Boolean> elementIsDisplayed = arg0 -> element.isDisplayed();
        wait.until(elementIsDisplayed);
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

    protected boolean isVisible(By locator){
       try {
           WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
           return webElement.isDisplayed();
       }
       catch (TimeoutException exception){
           return false;
       }

    }
    protected boolean isEnabled(By locator){
        try {
            WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return webElement.isEnabled();
        }
        catch (TimeoutException exception){
            return false;
        }

    }
    protected ArrayList<String> getValuesByAttribute(WebElement webElement,String attribute) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div:nth-child(2) > div > div.jss16 > div > div:nth-child(3) > img")));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(AboutTrackerLocator.IMAGES)));
        ArrayList<String> values = new ArrayList<>();
        for (WebElement element : elements) {
            values.add(element.getAttribute(attribute));
        }
        return values;
    }



}
