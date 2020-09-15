package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    // Static yaptık ki program çalışır çalışmaz Webdriver nesnesi oluşsun.

    private Driver(){ }
    static WebDriver driver;

    public static WebDriver getDriver () {

        if (driver== null){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        return driver;

        
    }

}
