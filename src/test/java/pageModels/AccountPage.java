package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Account']")
    private WebElement accountBreadcrumb;

    @FindBy(className = "img-responsive")
    private WebElement logo;

    public boolean isDisplayed() {
        return accountBreadcrumb.isDisplayed();
    }

    public void clickLogo() {
        logo.click();
    }
}
