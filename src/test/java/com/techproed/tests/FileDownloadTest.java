package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {


    @Test
    public void dosyaVarMi() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");
        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
        Assert.assertTrue(varMi);


    }

    @Test
    public void dosyaUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement upChooseFİle = driver.findElement(By.id("file-upload"));
        upChooseFİle.sendKeys("C:/Users/HP/Desktop/logo.png");
        driver.findElement(By.id("file-submit")).click();
        WebElement upLoadConfirm = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(upLoadConfirm.isDisplayed());

    }

    @Test
    public void dosyaDownload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement anmsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        anmsterdamLinki.click();
        Thread.sleep(7000);
        boolean varMi = Files.exists(Paths.get("/Users/cc/Downloads"));
        Assert.assertTrue(varMi);

    }

}
