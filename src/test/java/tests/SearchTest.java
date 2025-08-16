package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageModels.SearchPage;
import resources.Base;

public class SearchTest extends Base {
    @Test
    @Parameters({"item"})
    public void searchProd(String product) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct(product);
    }
}
