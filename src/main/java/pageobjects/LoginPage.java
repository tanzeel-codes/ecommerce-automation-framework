package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    private final static Logger logs = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginField;

    public LoginPage setEmail(String username) {
        logs.info("Entering email:" + username);
        emailField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        logs.info("Entering password");
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        loginField.click();
    }

    public void login(String user, String pass) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.doubleClick(emailField).click().perform();
        setEmail(user).setPassword(pass).clickLogin();
    }
}
