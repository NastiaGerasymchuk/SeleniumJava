package trackster.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import trackster.enums.Language;
import trackster.models.HomePageTestData;
import trackster.pages.HomePage;

import java.io.File;
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


    }


