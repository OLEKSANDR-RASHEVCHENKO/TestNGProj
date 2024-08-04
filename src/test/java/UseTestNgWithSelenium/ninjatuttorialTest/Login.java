package UseTestNgWithSelenium.ninjatuttorialTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.Date;

public class Login {
    @Test(priority = 1)
    public void verifyLoginWithValidCredentials(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("rashevchenkoo@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Gazmanov1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement validText = driver.findElement(By.xpath("//div[@id='account-account']//div[@class='row']//ul[1]//li[1]"));
        Assert.assertTrue(validText.isDisplayed());
        driver.quit();
    }
    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateEmails());
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Gazmdanov1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement validText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertTrue(validText.isDisplayed());
        driver.quit();
    }
    public String generateEmails(){
        Date date = new Date();
        return date.toString().replace(" ","_").replace(":"," ")+"gmail.com";
    }
}
