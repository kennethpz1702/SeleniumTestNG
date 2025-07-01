package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourCartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");

    @Override
    @Step("Esperando que la pagina Your Cart cargue")
    public void waitPageToLoad() {
        waitPage(checkoutButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de your cart")
    public void verifyPage() {
        Logs.info("Verificando la pagina de your cart");
        softAssert.assertTrue(find(checkoutButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Haciendo click en checkout")
    public void clickCheckout() {
        Logs.info("Haciendo click en checkout");
        find(checkoutButton).click();
    }
}
