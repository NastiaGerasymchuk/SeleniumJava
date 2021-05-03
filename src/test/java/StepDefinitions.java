import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
