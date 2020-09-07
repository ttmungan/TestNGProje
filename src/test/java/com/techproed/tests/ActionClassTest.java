package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {

   @Test
    public void sagTiklama(){
       driver.get("https://the-internet.herokuapp.com/context_menu");
       WebElement element = driver.findElement(By.id("hot-spot"));
       Actions actions = new Actions(driver);

       
         try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
       actions.contextClick(element).perform();


    }

    @Test
    public void ciftTiklama(){
       driver.get("http://demo.guru99.com/test/simple_context_menu.html");
       WebElement element = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
       Actions actions = new Actions(driver);
       actions.doubleClick(element).perform();
    }

    @Test
    public void tekTiklama(){
       driver.get("http://amazon.com");
       WebElement button = driver.findElement(By.id("nav-link-accountList"));
       Actions actions = new Actions(driver);
       actions.moveToElement(button).perform();

    }

    @Test
    public void asagiYukari() {

        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        actions.sendKeys(Keys.PAGE_UP).perform();

    }
    @Test
    public void  buyukKucukYazma () {
        driver.get("http://google.com");

        driver.findElement(By.name("q")).sendKeys(Keys.SHIFT + "hello live channell");
    }
    @Test
    public void dragAndDrop(){
        driver.get("http://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));
        WebElement aramaKutusu = driver.findElement(By.id("q"));

       Actions  actions = new Actions(driver);
       actions.dragAndDrop(logo,aramaKutusu).perform();

    }




    }




