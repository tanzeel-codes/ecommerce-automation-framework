package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import resources.Base;

public class CartTest extends Base{
    private final static Logger logs = LogManager.getLogger(CartTest.class);
    @Test
    public void productCart() {
        logs.info("Starting the product cart Test");

        // CartPage
        CartPage cartPage = new CartPage(driver);
        logs.info("In Cart Page");
        // Setting up the quantity of a required product
        cartPage.setQuantity("Mac", "3");

        // Update the page
        cartPage.updateCart();

        // Proceeding to checkout
        cartPage.checkoutProducts();
    }
}
