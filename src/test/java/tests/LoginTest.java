package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;
import resources.DataProviders;

public class LoginTest extends Base {
    private final static Logger logs = LogManager.getLogger(LoginTest.class);
    @BeforeSuite
    public void openApplication() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

//    @Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
    @Test
    @Parameters({"user", "pass"})
    public void login(String user, String pass) throws InterruptedException {
        logs.info("Starting Test LoginTest");

        // LANDING PAGE
        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropdown();
        landingPage.loginOption();
        logs.info("Successfully navigated to login page");

        // LOGIN PAGE
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);

        AccountPage accountPage = new AccountPage(driver);
        try {
            Assert.assertTrue(accountPage.editAccountOption());
            logs.info("Successfully logged in");
        }catch(Exception e) {
            logs.error("Incorrect email & password");
        }
    }

    @AfterSuite
    public void closure() {
        driver.quit();
        logs.info("Driver got closed");
    }
}
