package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjects.CheckoutPage;
import resources.Base;
import resources.DataProviders;

import java.time.Duration;

public class CheckoutTest extends Base {
    private final static Logger logs = LogManager.getLogger(CheckoutTest.class);

    @Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void checkout(String firstName, String lastName, String address1, String address2,String city, String postCode, String country, String region) throws InterruptedException {
        logs.info("Starting the checkout Test");

        // CheckOut Page
        CheckoutPage checkoutPage = new CheckoutPage(driver);


        // Billing Details
        logs.debug("In Billing Details section");
        checkoutPage.setNewDetails("yes");
        checkoutPage.setName(firstName, lastName);
        checkoutPage.setAddress(address1, address2);
        checkoutPage.setCity(city);
        checkoutPage.setPostCode(postCode);
        checkoutPage.setCountry(country);
        checkoutPage.setState(region);
        checkoutPage.proceedToDeliveryDetails();

        // Delivery Details
        logs.debug("In Delivery Details Section");

        checkoutPage.setNewDetails("no");
        checkoutPage.proceedToDeliveryMethod();

        // Delivery Method
        logs.debug("In Delivery Method Section");
        checkoutPage.mentionDeliveryMethod("Please leave the package on the door and do not ring the bell");
        checkoutPage.proceedToPayment();

        // Payment Method
        logs.debug("In Payment Method Section");
//        checkoutPage.paymentOption("now");
        checkoutPage.proceedToConfirmOrder();

    }
}
