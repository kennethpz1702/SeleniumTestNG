package automation;

import Pages.ItemDetailPage;
import Pages.LoginPage;
import Pages.ShoppingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class ItemDetailsTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navegando a la url");
        driver.get("https://www.saucedemo.com/");

        loginPage.waitPageToLoad(); //Espero que cargue la pagina

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad();
        shoppingPage.goToItemDetail("Sauce Labs Fleece Jacket");
        itemDetailPage.waitPageToLoad();
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
