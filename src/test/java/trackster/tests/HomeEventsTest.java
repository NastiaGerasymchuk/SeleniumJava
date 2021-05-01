package trackster.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import trackster.data.*;
import trackster.enums.Language;
import trackster.models.HomePageTestData;
import trackster.pages.HomePage;
import trackster.pages.LoginPage;
import trackster.pages.NavPage;
import trackster.pages.ParcelInfo;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class HomeEventsTest extends BaseTest{

    private static Stream<Arguments> homeData() {

        return Stream.of(
                Arguments.of(new HomePageTestData(
                        Language.ENGLISH.getProgrammerCode(),
                        "Find your parcel just in one moment",
                        "Track number",
                        "Fast tracking",
                        "Intuitive Interface",
                        "Archive Parcels",
                        "Our Partners")),
                Arguments.of(new HomePageTestData(
                        Language.UKRAINIAN.getProgrammerCode(),
                        "Знайдіть вашу посилку в один клік",
                        "Трек номер",
                        "Швидкий пошук",
                        "Простий інтерфейс",
                        "Архів посилок",
                        "Наші партнери"))
        );
    }
    @Test
    public void testGuru99TakeScreenShot() throws Exception{


        HomePage homePage=new HomePage(driver);

        //takeSnapShot(driver, "C:\\Users\\Admin\\Desktop\\screen\\test.png") ;

    }





//    @BeforeEach
//    public  void setUp(){
//
//    }

    @ParameterizedTest
    @MethodSource("homeData")
    public void shouldBeAbleToAddValues(HomePageTestData homeModel) {

        Integer language=homeModel.getLanguage();
        String parcelHeader=homeModel.getParcelHeader();
        String number=homeModel.getNumber();
        String fastTracking= homeModel.getFastTracking();
        String intuitiveInterface= homeModel.getIntuitiveInterface();
        String archiveParsels= homeModel.getArchiveParsels();
        String ourPartners=homeModel.getOurPartners();
        HomePage homePage=new HomePage(driver);
        homePage.changeLanguage(language);
        assertThat(homePage.getParselHeader(),is(parcelHeader));
        assertThat(homePage.getInputPlaceholderr(),is(number));
        assertThat(homePage.getFastSearchHeader(),is(fastTracking));
        assertThat(homePage.getSimpleInterface(),is(not(intuitiveInterface)));
        assertThat(homePage.getArchiveParsels(),is(archiveParsels));
        assertThat(homePage.getOurPartners(),is(ourPartners));
    }

    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.EXISTED_PARCEL, numLinesToSkip = 1)
    void existedParcel(String number){
        HomePage homePage=new HomePage(driver);
        homePage.setNumber(number);
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.getParcelNumber(),is(number));
    }
    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.NOT_EXISTED_PARCEL, numLinesToSkip = 1)
    void notExistedParcel(String number){
        HomePage homePage=new HomePage(driver);
        homePage.setNumber(number);
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.notFoundInfo(),is(ParserInfoLocator.NOT_FOUND_INFO));
    }
    @ParameterizedTest
    @CsvFileSource(files = trackster.data.CsvFileSource.INCORRECT_PARCEL_NUMBER, numLinesToSkip = 1)
    void incorrectParcelNumber(String number){
        HomePage homePage=new HomePage(driver);
        homePage.setNumber(number);
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.notFoundInfo(),is(ParserInfoLocator.INCORRECT_PARCEL_NUMBER));
    }
    @ParameterizedTest
    @CsvSource({
            //"204941",
            "2059000651468115",
            //"204948"
    })
    void existedParcelCsv(String number) throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.setNumber(number);
        ParcelInfo parcelInfo= homePage.searchParcel();
        assertThat(parcelInfo.getParcelNumber(),is(number));
    }

    @Test
    void loginForParsel(){
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
    }


