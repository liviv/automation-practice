package homework.pageobject;

import lesson09.g_add_assertall.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='SubmitLogin']/span")
    private WebElement signInButton;

    public void enterUsername(String username) {
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInButton.click();
    }

    public AccountPage logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }
}
