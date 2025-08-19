package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    Actions actions;
    private final static Logger logs = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "button-cart")
    private WebElement addToCartOption;

    @FindBy(id = "cart-total")
    private WebElement totalCartOption;

    @FindBy(xpath = "//p//i[@class='fa fa-shopping-cart']")
    private WebElement viewCartOption;

    @FindBy(xpath = "//p//i[@class='fa fa-share']")
    private WebElement checkoutOption;

    @FindBy(xpath = "//input[@class='form-control input-lg']")
    private WebElement searchField;

    @FindBy(id = "input-quantity")
    private WebElement quantityField;

    // DYNAMICALLY GENERATE THE XPATH FOR THE MENTIONED PRODUCT
    public WebElement product(String productName) {
        logs.info("Getting the element locator");
        String xPath = String.format("//img[contains(@title,'%s')][@class='img-responsive']", productName);
        logs.info("xPath Generated, Searching using the xPath");
        return driver.findElement(By.xpath(xPath));
    }

    // SEARCH PRODUCT BY GIVING NAME (MUST MATCH WITH PRODUCT)
    public void getProduct(String productName) {
        product(productName).click();
        logs.info("Successfully navigate to the product" + productName);
    }

    public void searchProduct(String product) {
        logs.info("Searching product" + product);
        searchField.sendKeys(product);
        searchField.submit();
    }



    public void addToCart() {
        logs.info("Adding the product to cart");
        addToCartOption.click();
    }

    public void checkout() {
        logs.info("Proceed on checkout directly");
        checkoutOption.click();
    }

    public void viewCart() {
        logs.info("Reviewing Products in View Cart");
        viewCartOption.click();
    }

    public void setQuantity(String quantity) {
        logs.info("Setting the quantity of product in product page");
        actions.doubleClick(quantityField).sendKeys(quantity).perform();
    }

    public void viewTotalCart() {
        logs.info("Checking all the product in total Cart");
        totalCartOption.click();
    }


}
