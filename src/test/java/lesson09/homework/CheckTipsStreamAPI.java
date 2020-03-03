package lesson09.homework;

import lesson09.d_add_basetest.BaseTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckTipsStreamAPI extends BaseTest {


    @Test(timeout = 5000l)
    public void verifyAllTipsAreCorrect() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");

      List<WebElement> dressTips = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")));
        System.out.println(dressTips.size());
        Assert.assertTrue("Tips do not contain text 'Dress'",dressTips.stream().allMatch(a->a.getText().contains("Dress")));
        driver.findElement(By.id("search_query_top"))
                .clear();

    }

}
