package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

@Test
    public void giris(){
    driver.get(ConfigReader.getProperty("fhc_login"));

    FhcTripLoginPage fhcTripLoginPage = new FhcTripLoginPage(driver);
    fhcTripLoginPage.userNameKutusu.sendKeys(ConfigReader.getProperty("username2"));
    fhcTripLoginPage.passwordKutusu.sendKeys(ConfigReader.getProperty("password2"));
    fhcTripLoginPage.confirmKutusu.submit();

}


}
