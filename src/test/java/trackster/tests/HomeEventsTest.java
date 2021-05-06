package trackster.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import trackster.data.ParserInfoLocator;
import trackster.enums.Language;
import trackster.models.HomePageTestData;
import trackster.pages.HomePage;
import trackster.pages.LoginPage;
import trackster.pages.NavPage;
import trackster.pages.ParcelInfo;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomeEventsTest extends BaseTest{

    private static Stream<Arguments> changeLanguageData() {

        return Stream.of(
                Arguments.of(new HomePageTestData(
                        Language.ENGLISH,
                        "Find your parcel just in one moment",
                        "Track number",
                        "Fast tracking",
                        "Intuitive Interface",
                        "Archive Parcels",
                        "Our Partners")),
                Arguments.of(new HomePageTestData(
                        Language.UKRAINIAN,
                        "Знайдіть вашу посилку в один клік",
                        "Трек номер",
                        "Швидкий пошук",
                        "Простий інтерфейс",
                        "Архів посилок",
                        "Наші партнери"))
        );
    }
    @ParameterizedTest
    @MethodSource("changeLanguageData")
    public void changeLanguage(HomePageTestData homeModel) {
        Language language=homeModel.getLanguage();
        String parcelHeader=homeModel.getParcelHeader();
        String number=homeModel.getNumber();
        String fastTracking= homeModel.getFastTracking();
        String intuitiveInterface= homeModel.getIntuitiveInterface();
        String archiveParcels= homeModel.getArchiveParsels();
        String ourPartners=homeModel.getOurPartners();
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isButtonLanguagePresent(),is(true));
        assertThat(homePage.isListLanguagePresent(),is(false));
        homePage.changeLanguage(language);
        assertThat(homePage.isListLanguagePresent(),is(false));
        assertThat(homePage.getParcelHeader(),is(parcelHeader));
        assertThat(homePage.getInputPlaceholder(),is(number));
        assertThat(homePage.getFastSearchHeader(),is(fastTracking));
        assertThat(homePage.getSimpleInterface(),is(intuitiveInterface));
        assertThat(homePage.getArchiveParcels(),is(archiveParcels));
        assertThat(homePage.getOurPartners(),is(ourPartners));
    }

    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.EXISTED_PARCEL, numLinesToSkip = 1)
    void existedParcel(String number){
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isInputEnabled(),is(true));
        assertThat(homePage.isSearchButtonEnabled(),is(false));
        homePage.setNumber(number);
        assertThat(homePage.isSearchButtonEnabled(),is(true));
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.getParcelNumber(),is(number));
    }
    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.NOT_EXISTED_PARCEL, numLinesToSkip = 1)
    void notExistedParcel(String number){
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isInputEnabled(),is(true));
        assertThat(homePage.isSearchButtonEnabled(),is(false));
        homePage.setNumber(number);
        assertThat(homePage.isSearchButtonEnabled(),is(true));
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.notFoundInfo(),is(ParserInfoLocator.NOT_FOUND_INFO));
    }
    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.INCORRECT_PARCEL_NUMBER, numLinesToSkip = 1)
    void incorrectParcelNumber(String number){
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isInputEnabled(),is(true));
        assertThat(homePage.isSearchButtonEnabled(),is(false));
        homePage.setNumber(number);
        assertThat(homePage.isSearchButtonEnabled(),is(true));
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.notFoundInfo(),is(ParserInfoLocator.INCORRECT_PARCEL_NUMBER));
    }


    @Test
    void loginForParcel(){
        HomePage homePage=new HomePage(driver);
        NavPage navPage= homePage.clickNav();
        LoginPage loginPage=navPage.login();
        loginPage.gmailLogin();
        loginPage.setEmail("herasymchuk.anastasiia@chnu.edu.ua");
        loginPage.goToPassword();
        loginPage.setPassword("78789878thin");
        HomePage myPage= loginPage.goToPage();
        myPage.setNumber("204941");
        myPage.searchParcel();
    }
    private static Stream<Arguments> photoData() {

        return Stream.of(
                Arguments.of(new ArrayList<String>(){
                        {
                                add("nova-poshta");
                                add("justin");
                                add("dhl");
                        }
                                                    })

                         );
    }
    @ParameterizedTest
    @MethodSource("photoData")
    void defaultValues(ArrayList<String> photos){
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isFindParcelPresent(),is(true));
        assertThat(homePage.isAboutTrackerPresent(photos),is(true));
        assertThat(homePage.isHeaderPresent(),is(true));


    }

    }


