package trackster.pages;

import trackster.data.HomeLocator;
import trackster.data.SiteConfigure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    private static String PAGE_URL= SiteConfigure.URL;
    @FindBy(css = HomeLocator.LANGUAGE)
    WebElement language;
    @FindBy(css = HomeLocator.NAV_BTN)
    WebElement navBtn;
    @FindBy(css = HomeLocator.FIND_PARSEL_HEADER)
    WebElement parselHeader;
    @FindBy(css = HomeLocator.INPUT_NUMBER)
    WebElement inputNumber;
    @FindBy(css = HomeLocator.QUICK_SEARCH)
    WebElement quickSearchHeader;
    @FindBy(css = HomeLocator.SIMPLE_INTERFACE)
    WebElement simpleInterface;
    @FindBy(css = HomeLocator.ARCHIVE_PARSELS)
    WebElement achiveParsels;
    @FindBy(css = HomeLocator.OUR_PARTNERS_HEADER)
    WebElement ourPartners;
    //Constructor
    public HomePage(WebDriver driver){
        super(driver);
        this.driver.get(PAGE_URL);

    }
    public HomePage changeLanguage(Integer languageName){
        wait.until(ExpectedConditions.visibilityOf(language));
        language.click();
        String urlString = String.format(HomeLocator.LANGUAGE_ITEMS, languageName);
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
    public String getParselHeader(){
      return getText(parselHeader);
    }
    public String getInputPlaceholderr(){
        String attribute="placeholder";
        return getAttribute(inputNumber,attribute);
    }
    public  HomePage setNumber(String number){
       sendKeys(inputNumber,number);
        return this;
    }
    public  String trackNumber(){
        String attribute="value";
       return getAttribute(inputNumber,attribute);

    }

    public String getFastSearchHeader(){
        return getText(quickSearchHeader);
    }
    public String getSimpleInterface(){
        return getText(simpleInterface);
    }
    public String getArchiveParsels(){
        return getText(achiveParsels);
    }
    public String getOurPartners(){
        return getText(ourPartners);
    }



}
