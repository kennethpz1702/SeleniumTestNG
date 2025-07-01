package automation;

import Pages.ShoppingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;

public class ShoppingTest extends BaseTest {
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyPageTest() {
        shoppingPage.verifyPage();
    }

}
