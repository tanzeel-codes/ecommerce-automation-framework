package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    private final static Logger logs = LogManager.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa fa-user']")
    private WebElement accountDropdown;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginOption;

    public void myAccountDropdown() {
        accountDropdown.click();
        logs.info("click on the account option");
    }

    public void loginOption() {
        loginOption.click();
        logs.info("click on the login option");
    }
}
