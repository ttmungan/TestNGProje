package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {


   private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        button.click();
        System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();

    }


    @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirmKutusu = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmKutusu.click();
        driver.switchTo().alert().accept();
 }

    @Test
    public void jsPromptTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        button.sendKeys("Hello World");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        driver.switchTo().alert().accept();
    }


    @AfterClass
    public void tearDown(){

    }
}
