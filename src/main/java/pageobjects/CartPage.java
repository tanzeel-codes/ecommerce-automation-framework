package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    Actions actions;
    private final static Logger logs = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkOut;

    @FindBy(xpath = "//button[@data-original-title='Update']")
    private WebElement update;

    @FindBy(xpath = "//button[@data-original-title='Remove']")
    private WebElement remove;

    @FindBy(xpath = "//a[text()='Continue Shopping']")
    WebElement toLandingPage;

    public void setQuantity(String product, String quantity) {
        logs.info("Setting up the quantity in cart page");
        String xPath = String.format("//td[text()='Product Name']/following::td/a[contains(text(), '%s')]/following::div[1]/input", product);

        WebElement quantityField = driver.findElement(By.xpath(xPath));

        actions.doubleClick(quantityField).sendKeys(quantity).perform();
        logs.info("Quantity has set for the product");
    }

    public void proceedToHomePage() {
        toLandingPage.click();
    }

    public void updateCart() {
        logs.info("Update the quantity on cart  page");
        update.click();
    }

    public void removeProduct() {
        logs.info("Removing the product from cart");
        remove.click();
    }

    public void checkoutProducts() {
        logs.info("Proceed to checkout");
        checkOut.click();
    }
}
