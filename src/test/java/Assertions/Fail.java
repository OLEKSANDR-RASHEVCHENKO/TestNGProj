package Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Fail {
    @Test
    public void SampleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        if (driver.findElement(By.linkText("MacBook")).isDisplayed()){
            fail();//import static org.testng.Assert.*; можно просто писать статик и выхывать метод по имени и все
        }
        driver.quit();
    }
}
