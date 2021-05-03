package trackster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trackster.data.*;

public class Header extends BasePage{
    @FindBy(css = HeaderLocator.LANGUAGE)
    WebElement language;
    @FindBy(css = HeaderLocator.NAV_BTN)
    WebElement navBtn;
    public Header(WebDriver driver){
        super(driver);
    }
    public HomePage changeLanguage(Integer languageName){
        wait.until(ExpectedConditions.visibilityOf(language));
        language.click();
        String urlString = String.format(HeaderLocator.LANGUAGE_ITEMS, languageName);
        By lang=By.cssSelector(urlString);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lang)));
        WebElement webElement=driver.findElement(lang);
        webElement.click();
        return new HomePage(driver);
    }
    public NavPage clickNav(){
        click(navBtn);
        return new NavPage(driver);
    }


    public boolean isButtonLanguagePresent(){
        By locator=By.cssSelector(HeaderLocator.LANGUAGE);
        return isVisible(locator);
    }
    public boolean isNavPresent(){
        By locator=By.cssSelector(HeaderLocator.NAV_BTN);
        return isVisible(locator);
    }
    public boolean isListLanguagePresent(){
        By locator=By.cssSelector(HeaderLocator.LANGUAGE_LIST);
        return isVisible(locator);
    }
    public boolean isBeginState(){
        return isButtonLanguagePresent()&&
                isNavPresent()&&
                !isListLanguagePresent();
    }
}
