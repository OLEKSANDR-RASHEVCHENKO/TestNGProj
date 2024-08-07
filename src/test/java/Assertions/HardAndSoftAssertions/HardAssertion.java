package Assertions.HardAndSoftAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
    @Test
    public void SampleMethode(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        String actualTitle=driver.getTitle();
        String expectedTitle = "Your StoreABS";
        Assert.assertEquals(actualTitle,expectedTitle);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/";
        Assert.assertEquals(actualURL,expectedURL);

        driver.findElement(By.name("search")).sendKeys("Hp", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

        driver.quit();
    }
}
