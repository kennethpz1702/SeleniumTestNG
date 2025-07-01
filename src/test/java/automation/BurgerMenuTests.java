package automation;

import Pages.LoginPage;
import Pages.MenuBurger;
import Pages.ShoppingPage;
import Pages.TopBar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class BurgerMenuTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final TopBar topBar = new TopBar();
    private final MenuBurger menuBurger = new MenuBurger();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navegando a la url");
        driver.get("https://www.saucedemo.com/");

        loginPage.waitPageToLoad(); //Espero que cargue la pagina

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad();

        topBar.openMenuBurger();
        menuBurger.waitPageToLoad();
    }

    @Test(groups = {regression, smoke})
    public void logoutTest() {
        menuBurger.clickLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = {regression})
    public void aboutLinkTest() {
        menuBurger.verifyAboutLink("https://saucelabs.com/");
    }
}
