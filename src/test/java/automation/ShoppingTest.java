package automation;

import Pages.ShoppingPage;
import data.ExcelReader;
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


    @Test(groups = {regression})
    public void productListPriceTest() {
        final var listaItems = ExcelReader.leerListaItemProductoExcel();
        shoppingPage.verifyProductsPrice(listaItems);
    }
}
