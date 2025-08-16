package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement loginField;

    private LoginPage setEmail(String username) {
        emailField.sendKeys(username);
        return this;
    }

    private LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    private void clickLogin() {
        loginField.click();
    }

    public void login(String user, String pass) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.doubleClick(emailField).click().perform();
        setEmail(user);
        setPassword(pass);
        clickLogin();
    }
}
