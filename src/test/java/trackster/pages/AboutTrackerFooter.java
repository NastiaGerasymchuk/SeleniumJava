package trackster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trackster.data.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AboutTrackerFooter extends BasePage{
    @FindBy(css = AboutTrackerLocator.QUICK_SEARCH)
    WebElement quickSearchHeader;
    @FindBy(css = AboutTrackerLocator.SIMPLE_INTERFACE)
    WebElement simpleInterface;
    @FindBy(css = AboutTrackerLocator.ARCHIVE_PARSELS)
    WebElement archiveParcels;
    @FindBy(css = AboutTrackerLocator.OUR_PARTNERS_HEADER)
    WebElement ourPartners;
    @FindBy(css = AboutTrackerLocator.IMAGES)
    WebElement images;
    public AboutTrackerFooter(WebDriver driver){
        super(driver);
    }
    public String getFastSearchHeader(){
        return getText(quickSearchHeader);
    }
    public String getSimpleInterface(){
        return getText(simpleInterface);
    }
    public String getArchiveParcels(){
        return getText(archiveParcels);
    }
    public String getOurPartners(){
        return getText(ourPartners);
    }
    protected boolean isHeaderPresent(){
        By locator=By.cssSelector(AboutTrackerLocator.HEADER);
        return isVisible(locator);
    }
    protected boolean isMainPresent(){
        By locator=By.cssSelector(AboutTrackerLocator.MAIN);
        return isVisible(locator);
    }
    protected boolean isFooterPresent(){
        By locator=By.cssSelector(AboutTrackerLocator.FOOTER);
        return isVisible(locator);
    }
    public boolean isAboutTrackerPresent(ArrayList<String> photos){
        return isHeaderPresent()&&
                isMainPresent()&&
                isFooterPresent()&&
                isImagesEquals(photos);
                
    }
    private boolean isImagesEquals(ArrayList<String> photos){
        ArrayList<String> isPresent= getValuesByAttribute(images,"alt");
        Collections.sort(isPresent);
        Collections.sort(photos);
        return photos.equals(isPresent);
    }
}
