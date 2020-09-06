package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void cokluPencereTest() {
       driver.get("https://the-internet.herokuapp.com/windows");

        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {


        }

        driver.getWindowHandles();
        Set<String> tumPenceler = driver.getWindowHandles();
        /*for (String w:tumPenceler) {
            System.out.println(w);


        }*/

        Object[] arr = (Object[])  tumPenceler.toArray();
        Object ikinciHandle = arr [arr.length-1];
        System.out.println(ikinciHandle);



    }


}
