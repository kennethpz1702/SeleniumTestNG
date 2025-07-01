package Pages;

import io.qameta.allure.Step;
import modelos.ItemProducto;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.BasePage;
import utilities.Logs;

import java.util.List;

public class ShoppingPage extends BasePage {
    private final By inventoryList = By.className("inventory_list");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By selecItem = By.cssSelector("select[data-test='product-sort-container']");

    private By getProductPrice(String itemName) {
        return RelativeLocator
                .with(By.className("inventory_item_price"))
                .below(getItemName(itemName));
    }

    private By getItemName(String itenName) { //Localizador dinámico.
        final var xpath = String.format("//div[text()='%s']", itenName);
        return By.xpath(xpath);
    }

    @Override
    @Step("Esperando que cargue la pagina de shopping")
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());
    }


    @Override
    @Step("Verificando la pagina de shopping")
    public void verifyPage() {
        Logs.info("Verificando la pagina de shoppin");
        softAssert.assertTrue(find(inventoryList).isDisplayed());
        softAssert.assertTrue(find(productsTitle).isDisplayed());
        softAssert.assertTrue(find(selecItem).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Navegando al detalle del item")
    public void goToItemDetail(String itemName) {
        Logs.info("Navegando al detalle de item: %s", itemName);
        find(getItemName(itemName)).click();
    }

    @Step("Verificando el precio de los productos")
    public void verifyProductsPrice(List<ItemProducto> listaItems) {
        Logs.info("Verificando el precio de los productos");

        for (var item : listaItems) {
            final var priceLabel = find(getProductPrice(item.getNombre()));
            final var price = Double.parseDouble(
                    priceLabel.getText().replace("$", "")
            );
            softAssert.assertEquals(
                    price, //Actual
                    item.getPrecio(), //esperado
                    String.format("fallo: %s", item.getNombre()) //Mensaje de error si falla
            );
        }

        softAssert.assertAll();
    }
}
