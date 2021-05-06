package trackster.pages;

import trackster.data.HomeLocator;
import trackster.data.SiteConfigure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trackster.enums.Language;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {


    private static String PAGE_URL= SiteConfigure.URL;
    private FindParcelMain findParcel;
    private AboutTrackerFooter aboutTracker;
    private Header header;

//    @FindBy(css = HomeLocator.FIND_PARSEL_HEADER)
//    WebElement parselHeader;
//    @FindBy(css = HomeLocator.INPUT_NUMBER)
//    WebElement inputNumber;


//    @FindBy(css = HomeLocator.QUICK_SEARCH)
//    WebElement quickSearchHeader;
//    @FindBy(css = HomeLocator.SIMPLE_INTERFACE)
//    WebElement simpleInterface;
//    @FindBy(css = HomeLocator.ARCHIVE_PARSELS)
//    WebElement achiveParsels;
//    @FindBy(css = HomeLocator.OUR_PARTNERS_HEADER)
//    WebElement ourPartners;



//    @FindBy(css = HomeLocator.SEARCH_BUTTON)
//    WebElement searchButton;
    //Constructor
    public HomePage(WebDriver driver){
        super(driver);
        this.driver.get(PAGE_URL);
        findParcel=new FindParcelMain(driver);
        aboutTracker=new AboutTrackerFooter(driver);
        header=new Header(driver);

    }
    public HomePage changeLanguage(Language languageName){
        return header.changeLanguage(languageName);
    }
    public boolean isButtonLanguagePresent(){
        return header.isButtonLanguagePresent();
    }
    public boolean isListLanguagePresent(){
        return header.isListLanguagePresent();
    }
    public boolean isInputEnabled(){
        return findParcel.isInputEnabled();
    }
    public boolean isSearchButtonEnabled(){
        return findParcel.isSearchEnabled();
    }
    public NavPage clickNav(){
        return header.clickNav();
    }
    public String getParcelHeader(){

        return findParcel.getParcelHeader();
    }
    public String getInputPlaceholder(){
        return findParcel.getInputPlaceholder();
    }
    public FindParcelMain setNumber(String number){
        return findParcel.setNumber(number);
    }
    public  String trackNumber(){
        return findParcel.trackNumber();

    }
    public ParcelInfo searchParcel(){
        return findParcel.searchParcel();
    }
    public boolean isFindParcelPresent(){
        return findParcel.allElementsPresent();
    }

    public String getFastSearchHeader(){
        return aboutTracker.getFastSearchHeader();
    }
    public String getSimpleInterface(){
        return aboutTracker.getSimpleInterface();
    }
    public String getArchiveParcels(){
        return aboutTracker.getArchiveParcels();
    }
    public String getOurPartners(){
        return aboutTracker.getOurPartners();
    }
    public boolean isAboutTrackerPresent(List<String> photos){
        return aboutTracker.isAboutTrackerPresent(photos);
    }
    public boolean isHeaderPresent(){
        return header.isBeginState();
    }





}
