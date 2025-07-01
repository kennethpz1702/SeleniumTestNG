package utilities;

import Pages.ItemDetailPage;
import Pages.LoginPage;
import Pages.MenuBurger;
import Pages.ShoppingPage;
import Pages.TopBar;
import data.DataGiver;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    public void goToLoginPage() {
        Logs.info("Navegando a la url");
        getDriver().get("https://www.saucedemo.com/");

        new LoginPage().waitPageToLoad();//Espera que carge la pagina
    }

    public void goToShoppingPage() {
        goToLoginPage();

        final var credencialesValidas = DataGiver.getValidCredentials();
        new LoginPage().fillLogin(
                credencialesValidas.getUsername(),
                credencialesValidas.getPassword()
        );
        new ShoppingPage().waitPageToLoad();
    }


    public void openBurgerMenu() {
        goToShoppingPage();

        new TopBar().openMenuBurger();
        ;
        new MenuBurger().waitPageToLoad();
    }

    public void goToItemDetail(String itemName) {
        goToShoppingPage();
        new ShoppingPage().goToItemDetail(itemName);
        new ItemDetailPage().waitPageToLoad();
    }
}
