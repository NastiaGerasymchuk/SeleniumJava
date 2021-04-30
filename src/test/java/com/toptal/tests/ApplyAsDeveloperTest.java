package com.toptal.tests;

import com.toptal.webpages.DeveloperApplyPage;
import com.toptal.webpages.DeveloperPortralPage;
import com.toptal.webpages.HomePage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyAsDeveloperTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\source\\repos\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        DeveloperPortralPage applyPage=  home.clickOnDeveloperApplyButton();
        assertTrue(applyPage.isPageOpened());
        DeveloperApplyPage developerApplyPage = new DeveloperApplyPage(driver);
        developerApplyPage.setRole();
        developerApplyPage.setFullName("Nastia Gerasymchuk");
        developerApplyPage.setEmail("nasta_2000@i.ua");
        developerApplyPage.setPassword("78789878");
        developerApplyPage.confirmPassword();
        developerApplyPage.confirmCookie();
        developerApplyPage.Apply();

//        //Create object of DeveloperPortalPage
//        DeveloperPortralPage devportal= new DeveloperPortralPage(driver);
//
//        //Check if page is opened
//        Assert.assertTrue(devportal.isPageOpened());
//
//        //Create object of DeveloperApplyPage
//        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);
//
//
//
//        //Fill up data
//        applyPage.setDeveloper_email("dejan@toptal.com");
//        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
//        applyPage.setDeveloper_password("password123");
//        applyPage.setDeveloper_password_confirmation("password123");
//        applyPage.setDeveloper_skype("automated_test_skype");
//
//        //Click on join
//        //applyPage.clickOnJoin();
    }

    @AfterAll
    public void close(){

        //driver.close();
    }
}

