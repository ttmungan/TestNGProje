package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {

    @Test
    public void giris(){
        driver.get("http:/facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.emailKutusu.sendKeys(ConfigReader.getProperty("email"));
        facebookLoginPage.sifreKutusu.sendKeys(ConfigReader.getProperty("password") + Keys.ENTER);
    }
}
