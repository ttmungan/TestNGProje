package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {

    public void girisTesti() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    @Test
    public void test(){

        girisTesti();
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(tumSatirlar.size());

        WebElement satirUc = driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(satirUc.getText());


        }

    }
}
