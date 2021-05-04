package cucumberFeature;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trackster.pages.HomePage;
import trackster.pages.ParcelInfo;
import trackster.tests.BaseTest;

import java.util.ArrayList;
import java.util.List;

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

    @Given("input filed is enabled")
    public void input_filed_is_enabled() {
        assertThat(homePage.isInputEnabled(),is(true));

    }

    @Given("search button is disabled")
    public void search_button_is_disabled() {
        //assertThat(homePage.isSearchButtonEnabled(),is(false));

    }

    @When("I input {string}")
    public void i_input(String number) {
        homePage.setNumber(number);

    }

    @When("search button is enabled")
    public void search_button_is_enabled() {
        assertThat(homePage.isSearchButtonEnabled(),is(true));

    }

    @When("Click search button")
    public void click_search_button() {
        parcelInfo= homePage.searchParcel();

    }

    @Then("I see information {string}")
    public void i_see_information(String info) {
        assertThat(parcelInfo.notFoundInfo(),is(info));
    }

    @When("I Click language button")
    public void i_click_language_button() {
        assertThat(homePage.isButtonLanguagePresent(),is(true));
        //assertThat(homePage.isListLanguagePresent(),is(false));

    }

    @When("Select one of the language from {int}")
    public void select_one_of_the_language_from(Integer language) {
        homePage.changeLanguage(language);
        //assertThat(homePage.isListLanguagePresent(),is(false));
    }

    @Then("All site's interface is translated on {string},{string},{string},{string},{string},{string}")
    public void all_site_s_interface_is_translated_on(String parcelHeader, String number, String fastTracking, String intuitiveInterface, String archiveParcels, String ourPartners) {

        assertThat(homePage.getParcelHeader(),is(parcelHeader));
        assertThat(homePage.getInputPlaceholder(),is(number));
        assertThat(homePage.getFastSearchHeader(),is(fastTracking));
        assertThat(homePage.getSimpleInterface(),is(intuitiveInterface));
        assertThat(homePage.getArchiveParcels(),is(archiveParcels));
        assertThat(homePage.getOurPartners(),is(ourPartners));
    }

    @Then("I see information about all partners of tracks")
    public void i_see_information_about_all_partners_of_tracks(io.cucumber.datatable.DataTable dataTable) {

        List<String> res = dataTable.column(0);
        ArrayList<String> photos = new ArrayList<String>(res);
        assertThat(homePage.isFindParcelPresent(),is(true));
        assertThat(homePage.isAboutTrackerPresent(photos),is(true));
        assertThat(homePage.isHeaderPresent(),is(true));
    }


}
