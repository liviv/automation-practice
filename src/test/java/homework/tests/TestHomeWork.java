package homework.tests;

import homework.custom_wait.MyCustomWaits;
import lesson09.d_add_basetest.BaseTest;
import lesson10.a_own_expected_condtition.CustomExpectedConditions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestHomeWork extends BaseTest {
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        new WebDriverWait(driver, 5).until(
                MyCustomWaits.pageIsLoaded("index", "My Store"));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void verifyContactUsPageIsLoaded() {
        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        new WebDriverWait(driver, 5).until(
                MyCustomWaits.pageIsLoaded("contact", "Contact us - My Store"));

    }

    @Test
    public void verifyTips() {
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");
        new WebDriverWait(driver, 10)
                .until(MyCustomWaits.listNthElementHasText(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"), 3,
                        "Dress"));
    }


}
