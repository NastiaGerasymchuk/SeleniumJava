package cucumberFeature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                features = {"classpath:Feature/changeLanguage.feature"},
                glue = {"cucumberFeature"})
public class RunCucumberTest {

}
