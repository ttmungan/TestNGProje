package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelProject extends TestBase {

    @BeforeMethod
    public void girisTesti(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

}

    @Test
    public void hotelCreation (){
        driver.findElement(By.id("Code")).sendKeys("1001");
        driver.findElement(By.id("Name")).sendKeys("Tulin Mungan");
        driver.findElement(By.id("Address")).sendKeys("Dertlerin Merkezi Turkiye");
        driver.findElement(By.id("Phone")).sendKeys("544248244");
        driver.findElement(By.id("Email")).sendKeys("tulintmungan@gmail.com");
        WebElement dropDown =driver.findElement(By.id("IDGroup"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        driver.findElement(By.id("btnSubmit")).submit();
        WebDriverWait wait = new WebDriverWait(driver, 30) ;
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed());

    }
}
