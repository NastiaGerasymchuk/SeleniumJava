package trackster.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import trackster.data.TestBugReport;

import java.io.File;

public class TestBugReporting extends BaseTest implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {

        String screenName= TestBugReport.SCREEN_PATH+extensionContext.getDisplayName();
        try {
            takeSnapShot(screenName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void takeSnapShot(String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
