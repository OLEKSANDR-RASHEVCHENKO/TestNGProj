package Annotation.BeforeAfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver ;
    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Test(priority = 1)
    public void verifyUserLoginWithValidCredentials(){
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("rashevchenkoo@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Gazmanov1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement verifyOptions=driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']"));
        Assert.assertTrue(verifyOptions.isDisplayed());
    }
@Test(priority = 2)
    public void verifyUserLoginWithValidUserNameAndInvalidPssword(){
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("rashevchenkoo@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Gazmanov123e");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String worningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(worningMessage,"Warning: No match for E-Mail Address and/or Password.");
    }
    @Test(priority = 3)
    public void verifyUserLoginWithValidPasswordAndInvalidUserNAme(){
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("rashevchenk4oo@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Gazmanov1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String worningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(worningMessage,"Warning: No match for E-Mail Address and/or Password.");

    }
    @Test(priority = 4)
    public void verifyUserLoginWithInvalidCredentials(){
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("rashevchenk4oo@gmadil.com");
        driver.findElement(By.id("input-password")).sendKeys("Gazmanov123d4");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String worningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(worningMessage,"Warning: No match for E-Mail Address and/or Password.");
    }
}
