package homework.tests;

import homework.custom_wait.MyCustomWaits;
import lesson09.d_add_basetest.BaseTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        new WebDriverWait(driver, 5).until(
                MyCustomWaits.pageIsLoaded("index", "My Store"));

    }

    @Test
    public void searchTipsTest() {
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("Printed Summer Dress");
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        List<WebElement> resultList = driver.findElements(By.xpath("//*[@id='center_column']/ul/li/div"));
        Assert.assertEquals("The search results did not contain 3 elements", 3, resultList.size());
        Assert.assertThat("The first result did not contain Printed Summer Dress", resultList.get(1).getText(),
                CoreMatchers.containsString("Printed Summer Dress"));

    }
}
