package automation;

import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navegando a la url");
        driver.get("https://www.saucedemo.com/");

        loginPage.waitPageToLoad(); //Espero que cargue la pagina
    }

    @Test
    public void usuarioInvalidoTest() {
        loginPage.fillLogin("locked_out_user", "secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    
}
