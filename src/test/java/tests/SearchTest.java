package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.ProductPage;
import resources.Base;

public class SearchTest extends Base {
    private final Logger logs = LogManager.getLogger(this.getClass());
    @Test
    public void search() {
        LoginTest loginTest = new LoginTest();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.hoverOverDeskTop().hoverOverMac().select();

        ProductPage productPage = new ProductPage(driver);
        productPage.getProduct("iMac");



    }
}
