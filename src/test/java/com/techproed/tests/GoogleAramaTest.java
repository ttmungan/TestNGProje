package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//TestVBaseFinal Class ını miras alıyoruz cunku TestBaseFinal icerisinde rapor almak icin
// kullanacagimiz nesneler ve methodlar var.

public class GoogleAramaTest extends TestBaseFinal {

    @Test
    public void aramaTesti (){

        extentTest = extentReports.createTest("Google Arama", "Google da techproeducation arattık");
        extentTest.info("sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
        extentTest.info("google da arama yapabilmek icin nesne olusturduk");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);
        extentTest.info("3 sn bekle");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        boolean linkVarMi = false;
        for (WebElement w : googleAramaPage.tumLinkler) {
            if (w.getText().contains("techproeducation123")) {
                linkVarMi = true;
                break;
            }

        }
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Test Basarili");

    }


}
