package trackster.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import trackster.data.*;

import java.io.File;

public class TestBugReporting extends BaseTest implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        String photoName="full_path_"+extensionContext.getRequiredTestMethod()+"_order_id_"+extensionContext.getDisplayName()+TestBugReport.PHOTO_EXTENSION;
        String screenName= TestBugReport.SCREEN_PATH+photoName;
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
