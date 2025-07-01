package automation;

import Pages.ItemDetailPage;
import Pages.ShoppingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;

public class ItemDetailsTests extends BaseTest {
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToItemDetail("Sauce Labs Fleece Jacket");
    }

    @Test(groups = {regression, smoke})
    public void verifyPageTest() {
        itemDetailPage.verifyPage();
    }

    @Test(groups = {regression})
    public void backToProductsTest() {
        itemDetailPage.clickBacToProduts();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
