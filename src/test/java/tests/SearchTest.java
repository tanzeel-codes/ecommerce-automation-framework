package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.ProductPage;
import resources.Base;

import java.io.IOException;

public class SearchTest extends Base {
    private final static Logger logs = LogManager.getLogger(SearchTest.class);

//    @Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
    @Test
    public void search() throws IOException {
        logs.info("Starting the product search Test");

        // ACCOUNT PAGE
        AccountPage accountPage = new AccountPage(driver);

        accountPage.hoverOverDeskTop().hoverOverMac().select();

        // PRODUCT PAGE
        ProductPage productPage = new ProductPage(driver);

        productPage.getProduct("Mac");

        productPage.setQuantity("2");
        productPage.addToCart();
        productPage.viewTotalCart();
        productPage.viewCart();

    }
}
