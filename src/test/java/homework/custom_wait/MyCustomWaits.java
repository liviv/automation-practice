package homework.custom_wait;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class MyCustomWaits {
    public static ExpectedCondition<WebElement> listNthElementHasText(By locator, int elNo, String expText) {


        return new ExpectedCondition<WebElement>() {
            private String actualText = "";

            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver webDriver) {
                try {
                    WebElement webElement = webDriver.findElements(locator).get(elNo);
                    actualText = webElement.getText();
                    return actualText.contains(expText) ? webElement : null;
                } catch (IndexOutOfBoundsException ignored) {
                }
                return null;
            }

            @Override
            public String toString() {
                return String.format("%dth element of list to have text %s while actual text was: %s", elNo, expText, actualText);
            }
        };
    }

    public static ExpectedCondition<WebElement> listNthElementHasTextLambda(By locator, int elNo, String expText) {

        return webDriver -> {
            try {
                WebElement webElement = webDriver.findElements(locator).get(elNo);
                String actualText = webElement.getText();
                return actualText.contains(expText) ? webElement : null;
            } catch (IndexOutOfBoundsException e) {
            }
            return null;
        };
    }

    public static ExpectedCondition<String> pageIsLoadedLambda(String expUrl, String expTitle) {

        return webDriver -> {
            String currentUrl = webDriver.getCurrentUrl();
            String currentTitle = webDriver.getTitle();
            if (currentUrl.contains(expUrl) && currentTitle.contains(expTitle)) {
                return currentUrl;
            } else {
                return null;
            }
        };

    }

    public static ExpectedCondition<String> pageIsLoaded(String expUrl, String expTitle) {

        return new ExpectedCondition<String>() {
            private String currentUrl;
            private String currentTitle;

            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver webDriver) {
                currentUrl = webDriver.getCurrentUrl();
                currentTitle = webDriver.getTitle();
                if (currentUrl.contains(expUrl) && currentTitle.contains(expTitle)) {
                    return currentUrl;
                } else {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "Url to contain " + expUrl + " and page title to contain " + expTitle +
                        " while actual Url was " + currentUrl + " and actual page title was " + currentTitle;
            }
        };
    }

    public ExpectedCondition<Boolean> stalenessOfElement(WebElement elToBeDisappeared) {
      return stalenessOf(elToBeDisappeared);
    };
}
