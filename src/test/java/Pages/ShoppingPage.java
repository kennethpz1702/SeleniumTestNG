package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {
    private final By inventoryList = By.className("inventory_list");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By selecItem = By.cssSelector("select[data-test='product-sort-container']");

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
}
