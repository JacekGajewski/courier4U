package com.example.springBoot.selenium;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest

{

    private WebDriver webDriver;




    @Before
    public void setup(){

        //if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        //Now you can Initialize marionette driver to launch firefox
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        webDriver = new FirefoxDriver();
    }

    @Test
    public void seleniumTest() throws Exception{

        webDriver.navigate().to("http://localhost:8080/pojazdy/list");
        Thread.sleep(2000);

        //Wykonaj filtrowanie
        webDriver.findElement(By.id("filtrBtn")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("lokalizacjaFiltr")).sendKeys("Wrocław");
        webDriver.findElement(By.id("filtrBtn")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("lokalizacjaFiltr")).sendKeys("");
        webDriver.findElement(By.id("filtrBtn")).click();
        Thread.sleep(1000);

        //Wykonaj przypadki płatności
        webDriver.navigate().to("http://localhost:8080/pojazdy/list");
        Thread.sleep(2000);

        webDriver.findElement(By.linkText("Iveco")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("cofnijBtn")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.linkText("Ford")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("zamowBtn")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("gotowkaBtn")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.linkText("Cofnij")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("kartaBtn")).click();
        Thread.sleep(1000);

        WebElement danePosiadacza = webDriver.findElement(By.id("danePosiadacza"));
        danePosiadacza.sendKeys("John Doe");
        Thread.sleep(1000);

        WebElement numerKarty = webDriver.findElement(By.id("numerKarty"));
        numerKarty.sendKeys("123456789101011");
        Thread.sleep(1000);

        webDriver.findElement(By.id("cvv")).sendKeys("123");
        Thread.sleep(1000);

        webDriver.findElement(By.id("submitBtn")).click();

        //Komunikat o błędzie
        webDriver.findElement(By.id("cvv")).sendKeys("");
        Thread.sleep(1000);

        webDriver.findElement(By.id("submitBtn")).click();
    }

}

