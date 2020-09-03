package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test01(){


        driver.get("http://www.amazon.com");
        String title = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(title.contains("Amazon"));
        softAssert.assertTrue(title.contains("Car"));
        softAssert.assertEquals("Online", title);
        softAssert.assertAll();

    }

    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");

        SoftAssert softAssert = new SoftAssert();
        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com" +Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        softAssert.assertTrue(driver.getTitle().equals("Deneme"));

        WebElement sifreKutusu =driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!" + Keys.ENTER);
        softAssert.assertTrue(driver.getTitle().equals("Adress book"));
        WebElement signIn = driver.findElement(By.name("commit"));
        signIn.submit();


        WebElement signOutLinki = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu = signOutLinki.isDisplayed();
       // Assert.assertTrue(gorunuyorMu);

        softAssert.assertAll();
    }


}
