package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    @Step("Esperando que cargue la pagina de login")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de login")
    public void verifyPage() {
        Logs.info("Verificamos la pagina de login");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Rellenando el formulario de login")
    public void fillLogin(String username, String password) {
        Logs.info("Escribiendo el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escribiendo el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Haciendo click en el boton de login");
        find(loginButton).click();
    }

    @Step("Verificando el mensaje de error y su texto")
    public void verifyErrorMessage(String textoError) {
        final var errorLabel = find(errorMessage);

        Logs.info("Verificando el mensaje de error y su texto");
        softAssert.assertTrue(errorLabel.isDisplayed());
        softAssert.assertEquals(errorLabel.getText(), textoError);
        softAssert.assertAll();
    }
}
