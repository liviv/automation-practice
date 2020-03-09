package homework.tests;

import homework.custom_wait.MyCustomWaits;
import lesson09.d_add_basetest.BaseTest;
import lesson09.g_add_assertall.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AccountTest extends BaseTest {

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        new WebDriverWait(driver, 5).until(
                MyCustomWaits.pageIsLoaded("index", "My Store"));

    }

    @BeforeClass
    public static void logIn() {

        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='email']")));
        driver.findElement(By.id("email")).sendKeys("viktorialvov@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Passwdlm");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @After
    public void returnToMyAccount() {
        driver.findElement(By.xpath("//*[@id='columns']/div[1]/a[2]")).click();
    }

    @Test
    public void openOrderHistoryAndDetails() {
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")).click();
        new WebDriverWait(driver, 5).
                until(MyCustomWaits.pageIsLoaded("http://automationpractice.com/index.php?controller=history",
                        "Order history"));
    }

    @Test
    public void openMyCreditSlips() {
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[2]/a/span")).click();
        new WebDriverWait(driver, 5).
                until(MyCustomWaits.pageIsLoaded("http://automationpractice.com/index.php?controller=order-slip",
                        "Order slip"));
    }

    @Test
    public void openMyAdresses() {
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")).click();
        new WebDriverWait(driver, 5).
                until(MyCustomWaits.pageIsLoaded("http://automationpractice.com/index.php?controller=addresses",
                        "Addresses"));
    }

    @Test

    public void openMyPersonalInformation() {
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")).click();
        new WebDriverWait(driver, 5).
                until(MyCustomWaits.pageIsLoaded("http://automationpractice.com/index.php?controller=identity",
                        "Identity"));
    }

    @Test
    public void openMyWishlists() {
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[2]/ul/li/a/span")).click();
        new WebDriverWait(driver, 5).
                until(MyCustomWaits.pageIsLoaded("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist",
                        "My Store"));
    }
}
