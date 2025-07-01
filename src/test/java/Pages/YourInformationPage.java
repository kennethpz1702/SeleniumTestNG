package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourInformationPage extends BasePage {
    private final By firtsNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipcodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorLabel = By.cssSelector("h3[data-test='error']");

    @Override
    @Step("Esperando que la pagina de your information cargue")
    public void waitPageToLoad() {
        waitPage(firtsNameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de your information")
    public void verifyPage() {
        Logs.info("Verificando la pagina de your information");
        softAssert.assertTrue(find(firtsNameInput).isDisplayed());
        softAssert.assertTrue(find(lastNameInput).isDisplayed());
        softAssert.assertTrue(find(zipcodeInput).isDisplayed());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Rellenando el formulario")
    public void fillData(String name, String lastname, String zicode) {
        if (!name.isEmpty()) { //Si el name está vacío no escribe nada
            Logs.info("Escribiendo el firstname");
            find(firtsNameInput).sendKeys(name);
        }

        if (!name.isEmpty()) { //Si el lastname está vacío no escribe nada
            Logs.info("Escribiendo el lastname");
            find(lastNameInput).sendKeys(lastname);
        }

        if (!name.isEmpty()) { //Si el zip está vacío no escribe nada
            Logs.info("Escribiendo el zipcode");
            find(zipcodeInput).sendKeys(zicode);
        }

        Logs.info("Haciendo click en continue");
        find(continueButton).click();

    }

    @Step("Verificando el mensaje de error")
    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Verificando el mensaje de error");
        final var errorLabelElement = find(errorLabel);

        softAssert.assertTrue(errorLabelElement.isDisplayed());
        softAssert.assertEquals(errorLabelElement.getText(), errorMessage);
        softAssert.assertAll();
    }
}
