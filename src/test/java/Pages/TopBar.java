package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBar extends BasePage {
    private final By title = By.xpath("//div[text()='Swag Labs']");
    private final By menuBurguer = By.id("react-burger-menu-btn");
    private final By shoppingButton = By.className("shopping_cart_link");

    @Override
    public void waitPageToLoad() {

    }

    @Override
    @Step("Verificando el top bar")
    public void verifyPage() {
        Logs.info("Verificando el top bar");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(menuBurguer).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Abriendo el menu burger")
    public void openMenuBurger() {
        Logs.info("Abriendo el menu burger");
        find(menuBurguer).click();
    }

    @Step("Haciendo click en el boton de shopping cart")
    public void clickShoppingCart() {
        Logs.info("Haciendo click en el boton de shopping cart");
        find(shoppingButton).click();
    }
}
