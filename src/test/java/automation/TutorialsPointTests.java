package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class TutorialsPointTests extends BaseTest {
    @Test
    public void pestanaTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        Logs.debug("Obteniendo el id de la pestaña actual para reconocerlo posteriormente");
        final var tabId = driver.getWindowHandle();
        Logs.debug("tabId: %s", tabId);

        Logs.info("Haciendo click en el boton new tab");
        driver.findElement(By.xpath("//button[text()='New Tab']")).click();

        final var windowHandlesSet = driver.getWindowHandles();
        Logs.debug("Window handles set: %s", windowHandlesSet);

        Logs.debug("Nos posicionamos en la nueva pestaña");

        for (var windowHandle : windowHandlesSet) {
            //si no es el tap original es el de la nueva pestaña
            if (!windowHandle.equals(tabId)) {
                //Nos posicionamos en la nueva pestaña
                driver.switchTo().window(windowHandle);
            }
        }

        Logs.info("Verificando el texto");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='New Tab']")).isDisplayed());

        Logs.info("Cerrando la pestaña actual");
        driver.close();

        Logs.debug("Regresando el focus a la ventana original");
        driver.switchTo().window(tabId);

        Logs.info("Verificando que se regresó a la ventana principal");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Browser Windows']")).isDisplayed());
    }

    @Test
    public void ventanaTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        Logs.debug("Obteniendo el id de la ventana actual para reconocerlo posteriormente");
        final var windowId = driver.getWindowHandle();
        Logs.debug("windowId: %s", windowId);

        Logs.info("Haciendo click en el boton new window");
        driver.findElement(By.xpath("//button[text()='New Window']")).click();

        final var windowHandlesSet = driver.getWindowHandles();
        Logs.debug("Window handles set: %s", windowHandlesSet);

        Logs.debug("Nos posicionamos en la nueva ventana");

        for (var windowHandle : windowHandlesSet) {
            //si no es el tap original es el de la nueva ventana
            if (!windowHandle.equals(windowId)) {
                //Nos posicionamos en la nueva ventana
                driver.switchTo().window(windowHandle);
            }
        }

        Logs.info("Verificando el texto");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='New Window']")).isDisplayed());

        Logs.info("Cerrando la ventana actual");
        driver.close();

        Logs.debug("Regresando el focus a la ventana original");
        driver.switchTo().window(windowId);

        Logs.info("Verificando que se regresó a la ventana principal");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Browser Windows']")).isDisplayed());

    }
}
