package trackster.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import trackster.data.*;

@ExtendWith(TestBugReporting.class)
public class BaseTest {
    protected  static WebDriver driver;

    @BeforeAll
    public static void setup(){
      System.setProperty(BrowserConfigure.BRAWLER_NAME, BrowserConfigure.DESKTOP_PATH);
      driver=new ChromeDriver();
      driver.manage().window().maximize();
    }


    @AfterAll
    public static void TearDown(){

        driver.close();
    }

//    @AfterEach
//    public void tearDown(TestInfo info) throws Exception{
//
//        //System.out.println(Arrays.stream().toList());
//        System.out.println(info.getDisplayName());
////        System.out.println(TestExecutionResult.Status.values());
////        System.out.println(info.getDisplayName());
//

   // }



   }

