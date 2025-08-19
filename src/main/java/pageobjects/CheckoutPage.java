package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    Select select;
    Actions actions;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private final static Logger logs = LogManager.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[value='new']")
    private WebElement newDetails;

    @FindBy(css = "[value ='existing']")
    private WebElement existingDetails;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-payment-address-1")
    private WebElement addressField_1;

    @FindBy(id = "input-payment-address-2")
    private WebElement addressField_2;

    @FindBy(id = "input-payment-city")
    private WebElement cityField;

    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeField;

    @FindBy(id = "input-payment-country")
    private WebElement countryDropdown;

    @FindBy(id = "input-payment-zone")
    private WebElement regionDropdown;

    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement orderCommentField;

    @FindBy(id = "button-payment-address")
    private WebElement proceedToDeliveryDetails;

    @FindBy(id = "button-shipping-address")
    private WebElement proceedToDeliveryMethod;

    @FindBy(id = "button-shipping-method")
    private WebElement proceedToPaymentMethod;

    @FindBy(id = "button-payment-method")
    private WebElement proceedToConfirm;

    @FindBy(css = "[value='paypal']")
    private WebElement payPal;

    @FindBy(css = "[value='paypal_paylater']")
    private WebElement paypalPaylater;


    @FindBy(css = "[value='Continue']")
    private WebElement continueProcess;

    public void setNewDetails(String yesOrNo) {
        try {
            existingDetails.isDisplayed();
            if(yesOrNo.equalsIgnoreCase("Yes")) {
                newDetails.click();
                logs.info("Creating new details");
            }else {
                existingDetails.click();
            }
        }catch (Exception e) {
            logs.error("No previous details exists");
        }
    }

    public void setName(String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        logs.info("Set first name");

        lastNameField.sendKeys(lastName);
        logs.info("Set last name");
    }

    public void setAddress(String address_1, String address_2) {
        addressField_1.sendKeys(address_1);
        logs.info("Set address1");

        addressField_2.sendKeys(address_2);
        logs.info("Set address2");
    }

    public void setCity(String cityName) {
        cityField.sendKeys(cityName);
        logs.info("Set cityName");
    }

    public void setPostCode(String postCode) {
        postCodeField.sendKeys(postCode);
        logs.info("Set PostCode");
    }

    public void setCountry(String countryName) {
        select = new Select(countryDropdown);

        select.selectByVisibleText(countryName);
        logs.info("Selecting country");
    }

    public void setState(String regionName) {
        select = new Select(regionDropdown);

        select.selectByVisibleText(regionName);
        logs.info("Selecting region");
    }

    public void proceedToDeliveryDetails() {
        wait.until(ExpectedConditions.visibilityOf(proceedToDeliveryDetails));
        actions.moveToElement(proceedToDeliveryDetails).click().perform();
        logs.info("Continue to Delivery Detail");
    }

    public void proceedToDeliveryMethod() {
        wait.until(ExpectedConditions.visibilityOf(proceedToDeliveryMethod));
        actions.moveToElement(proceedToDeliveryMethod).click().perform();
        logs.info("Continue to Delivery Method");
    }

    public void proceedToPayment() {
        wait.until(ExpectedConditions.visibilityOf(proceedToPaymentMethod));
        actions.moveToElement(proceedToPaymentMethod).click().perform();
        logs.info("Continue to payment");
    }

    public void proceedToConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOf(proceedToConfirm));
        actions.moveToElement(proceedToConfirm).click().perform();
        logs.info("Continue to Confirm Order");
    }

    public void mentionDeliveryMethod(String comment) {
        orderCommentField.sendKeys(comment);
        logs.info("Delivery Method has been mentioned");
    }

    public void paymentOption(String payNowOrLater) {
        if(payNowOrLater.equalsIgnoreCase("now")) {
            payPal.click();
        }else {
            paypalPaylater.click();
        }
    }
}
