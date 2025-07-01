package automation;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class NavegacionTest extends BaseTest {
    @Test
    public void ejercicio1Test() {
        final var url = "https://www.saucedemo.com/";

        Logs.info("Navegando a: %s", url);
        driver.get(url);

        try {
            Thread.sleep(3000); // o el tiempo que necesites
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Logs.info("Obteniendo la url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las urls sean iguales");
        Assert.assertEquals(currentUrl, url);
    }

    @Test
    public void ejercicio2Test() {
        final var urlHeroku = "https://the-internet.herokuapp.com/";
        final var urlGitHub = "https://github.com/";

        Logs.info("Navegando a: %s", urlHeroku);
        driver.get(urlHeroku);

        Logs.info("Navegando a: %s", urlGitHub);
        driver.get(urlGitHub);

        Logs.info("Regresando a la pagina anterior");
        driver.navigate().back();

        Logs.info("Obteniendo la url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las urls sean iguales");
        Assert.assertEquals(currentUrl, urlHeroku);
    }

    @Test
    public void siempreFallaTest() {
        final var url = "https://the-internet.herokuapp.com/";

        Logs.info("Navegando a: %s", url);
        driver.get(url);

        Logs.info("Obteniendo la url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando las urls");
        Assert.assertEquals(currentUrl, "hola mundo");
    }
}
