package testReportingAllure;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import trackster.tests.HomeEventsTest;


@RunWith(JUnitPlatform.class)
@SelectClasses( { HomeEventsTest.class } )
@SelectPackages("trackster.tests")
public class TestSuite {
}