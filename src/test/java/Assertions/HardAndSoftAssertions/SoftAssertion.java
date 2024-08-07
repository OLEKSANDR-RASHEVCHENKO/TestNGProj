package Assertions.HardAndSoftAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    @Test
    public void SampleMethode(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        String actualTitle=driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "Your StoreABS";
        softAssert.assertEquals(actualTitle,expectedTitle);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/";
        softAssert.assertEquals(actualURL,expectedURL);

        driver.findElement(By.name("search")).sendKeys("Hp", Keys.ENTER);
        softAssert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());


        driver.quit();
        softAssert.assertAll();

        // softAssertion проверит все асершены даже если например уже первый фейлится
    }
}
