package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;
    Actions action;
    private final static Logger logs = LogManager.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Edit your account information']")
    private WebElement editAccountInformationOption;

    @FindBy(className = "img-responsive")
    private WebElement logo;

    @FindBy(xpath = "//a[text()='Desktops']")
    private WebElement desktop;

    @FindBy(xpath = "//a[text()='Mac']")
    private WebElement mac;

    @FindBy(xpath = "//a[@class='see-all'][text()='Show All Desktops']")
    WebElement showAllDesktopOption;

    public boolean editAccountOption() {
        logs.info("Verifying the Login status");
        return editAccountInformationOption.isDisplayed();
    }

    public AccountPage hoverOverDeskTop() {
        logs.info("Hover over the desktop option");
        action.moveToElement(desktop).perform();
        return this;
    }

    public AccountPage hoverOverShowAllDesktop() {
        logs.info("Hover over the show all desktop option");
        action.moveToElement(showAllDesktopOption).perform();
        return this;
    }

    public AccountPage hoverOverMac() {
        logs.info("Hover over the mac option");
        action.moveToElement(mac).perform();
        return this;
    }

    public void select() {
        action.click().perform();
        logs.debug("Successfully navigate to the product");
    }

    public void clickLogo() {
        logo.click();
    }
}
