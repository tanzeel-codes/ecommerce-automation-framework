package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageModels.AccountPage;
import pageModels.LoginPage;
import resources.Base;

public class LoginTest extends Base {

    @Test
    @Parameters({"user", "pass"})
    public void loginTest(String user, String pass) throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);

        AccountPage accountPage = new AccountPage(driver);
        VerificationTest.verify(accountPage);

        accountPage.clickLogo();
    }
}
