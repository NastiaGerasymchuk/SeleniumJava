package trackster.pages;
import org.openqa.selenium.WebElement;
import trackster.data.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ParcelInfo extends BasePage {

@FindBy(css = ParserInfoLocator.PARCEL_NUMBER)
    WebElement parcelNumber;
@FindBy(css = ParserInfoLocator.NOT_FOUND)
    WebElement notFoundInfo;
@FindBy(css = ParserInfoLocator.PARCEL_CARD_INFO)
WebElement parcelCard;
    public ParcelInfo(WebDriver driver){
        super(driver);
    }
    public String getParcelNumber(){
        return getText(parcelNumber);
    }
    public String notFoundInfo(){
        return getText(notFoundInfo);
    }

}
