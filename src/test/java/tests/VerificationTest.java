package tests;

import org.testng.Assert;
import pageModels.AccountPage;
import resources.Base;

public class VerificationTest extends Base {

    public static void verify(AccountPage obj) {
        try{
            Assert.assertTrue(obj.isDisplayed());
        }catch (Exception e) {
            System.out.println("User And Password Is Incorrect");
        }
    }

}
