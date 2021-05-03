package trackster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trackster.data.*;

public class FindParcelMain extends BasePage{
    public FindParcelMain(WebDriver driver){
        super(driver);
    }
    @FindBy(css = FindParcelLocator.FIND_PARSEL_HEADER)
    WebElement parcelHeader;
    @FindBy(css = FindParcelLocator.INPUT_NUMBER)
    WebElement inputNumber;
    @FindBy(css = FindParcelLocator.SEARCH_BUTTON)
    WebElement searchButton;
    @FindBy(css = FindParcelLocator.CAMERA_BUTTON)
    WebElement cameraButton;
    public String getParcelHeader(){
        return getText(parcelHeader);
    }
    public String getInputPlaceholder(){
        String attribute="placeholder";
        return getAttribute(inputNumber,attribute);
    }
    public FindParcelMain setNumber(String number){
        sendKeys(inputNumber,number);
        return this;
    }
    public  String trackNumber(){
        String attribute="value";
        return getAttribute(inputNumber,attribute);

    }
    public ParcelInfo searchParcel(){
        click(searchButton);
        return new ParcelInfo(driver);
    }
    private boolean isHeaderPresent(){
        By locator=By.cssSelector(FindParcelLocator.FIND_PARSEL_HEADER);
        return isVisible(locator);
    }
    private boolean isInputPresent(){
        By locator=By.cssSelector(FindParcelLocator.INPUT_NUMBER);
        return isVisible(locator);
    }
    private boolean isSearchPresent(){
        By locator=By.cssSelector(FindParcelLocator.SEARCH_BUTTON);
        return isVisible(locator);
    }
    private boolean isCameraPresent(){
        By locator=By.cssSelector(FindParcelLocator.CAMERA_BUTTON);
        return isVisible(locator);
    }
    public boolean allElementsPresent(){
        return isHeaderPresent()&&
                isInputPresent()&&
                isSearchPresent()&&
                isCameraPresent();
    }
    public boolean isInputEnabled(){
        By locator=By.cssSelector(FindParcelLocator.INPUT_NUMBER);
        return isEnabled(locator);
    }
    public boolean isSearchEnabled(){
        By locator=By.cssSelector(FindParcelLocator.SEARCH_BUTTON);
        return isEnabled(locator);
    }

}
