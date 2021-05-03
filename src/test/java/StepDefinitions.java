import com.toptal.webpages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trackster.data.ParserInfoLocator;
import trackster.pages.HomePage;
import trackster.pages.ParcelInfo;
import trackster.tests.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitions extends BaseTest {
    private HomePage homePage;
    private ParcelInfo parcelInfo;
    @Given("User")
    public void user() {
        setup();
        homePage=new HomePage(driver);
    }

    @When("I input not existed number of parcel")
    public void i_input_not_existed_number_of_parcel() {
        homePage.setNumber("78888");
    }

    @When("Click search button")
    public void click_search_button() {
         parcelInfo= homePage.searchParcel();
    }

    @Then("I see information {string}")
    public void i_see_information(String string) {
        assertThat(parcelInfo.notFoundInfo(),is(ParserInfoLocator.NOT_FOUND_INFO));
    }
}
