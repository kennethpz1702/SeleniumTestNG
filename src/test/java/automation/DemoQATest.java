package automation;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

import java.time.Duration;

public class DemoQATest extends BaseTest {
    @Test
    public void keyboard1Test() {
        Logs.info("Navegando a la pagina");
        driver.get("https://demoqa.com/text-box");

        final var faker = new Faker();
        final var fullName = faker.name().fullName();
        Logs.debug("fullname: %s", fullName);

        final var usernameInput = driver.findElement(By.id("userName"));
        Logs.info("Haciendo click para dar focus");
        usernameInput.click();

        Logs.info("Presionando SHIFT y escribiendo en mayusculas");
        new Actions(driver)
                .keyDown(Keys.SHIFT) //Presiono shift
                .sendKeys(fullName) //Escribo el fullname
                .keyUp(Keys.SHIFT) //Dejo de presionar SHIFT
                .perform();  //Realizo las acciones

        Logs.info("Verificando que el input este en mayusculas");
        Assert.assertEquals(
                usernameInput.getAttribute("value"),
                fullName.toUpperCase()
        );

    }

    @Test
    public void keyboard2Test() {
        Logs.info("Navegando a la pagina");
        driver.get("https://demoqa.com/text-box");

        final var faker = new Faker();
        final var adress = faker.address().fullAddress();
        Logs.debug("Adress: %s", adress);

        final var currentAdressInput = driver.findElement(By.id("currentAddress"));

        Logs.info("Escribiendo la dirección y dando focus");
        currentAdressInput.sendKeys(adress);
        currentAdressInput.click();

        Logs.info("Seleccionando y copiando el contenido");
        new Actions(driver)
                .keyDown(Keys.CONTROL) //presiono Control
                .sendKeys("a") //Control + C
                .sendKeys("c") //Control + C
                .keyUp(Keys.CONTROL) //Suelto Control
                .perform(); //Realizo las acciones

        final var permanentAdressInput = driver.findElement(By.id("permanentAddress"));

        // Hacer scroll al campo para evitar que el anuncio lo bloquee
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentAdressInput);

// Espera un poco (por si carga el anuncio)
        try {
            Thread.sleep(1000); // también puedes usar WebDriverWait si lo prefieres
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Logs.info("Doy focus haciendo click");
        permanentAdressInput.click();

        Logs.info("Pegando el contenido");
        new Actions(driver)
                .keyDown(Keys.CONTROL) //Presiono Control
                .sendKeys("v") //Control + v
                .keyUp(Keys.CONTROL) //Suelto Control
                .perform(); //Realizo las acciones

        Logs.info("Verificando que ambos inputs tengan el mismo texto");
        Assert.assertEquals(
                permanentAdressInput.getAttribute("value"),
                currentAdressInput.getAttribute("value")
        );


    }

    @Test
    public void mouse1Test() {
        Logs.info("Navegando a la página");
        driver.get("https://demoqa.com/droppable");

        final var figuraOrigen = driver.findElement(By.id("draggable"));
        final var figuraDestino = driver.findElement(By.id("droppable"));

        Logs.info("Arrastrame ls figura origen a la de destino");
        new Actions(driver)
                .dragAndDrop(figuraOrigen, figuraDestino) //Arrastra origen a destino
                .perform();

        Logs.info("Verificando que el label dropped sea visible");
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Drop here']")).isDisplayed());

    }

    @Test
    public void alert1Test() {
        Logs.info("Navegando a la página");
        driver.get("https://demoqa.com/alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        Logs.info("Esperando que cargue la página");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1[text()='Alerts']")));

        Logs.info("Haciendo click en el boton para que aparezca el alert");
        driver.findElement(By.id("alertButton")).click();

        Logs.debug("Obteniendo el alert");
        final var alert = (Alert) wait.until(ExpectedConditions.alertIsPresent());

        Logs.info("Verificando que el texto del alert sea correcto");
        Assert.assertEquals(alert.getText(), "You clicked a button");

        Logs.info("Presionando el boton del alert");
        alert.accept();
    }

    @Test
    public void alert2Test() {
        Logs.info("Navegando a la página");
        driver.get("https://demoqa.com/alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        Logs.info("Esperando que cargue la página");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1[text()='Alerts']")));

        Logs.info("Haciendo click en el boton para que aparezca el confirm");
        driver.findElement(By.id("confirmButton")).click();

        Logs.debug("Obteniendo el alert");
        final var alert = (Alert) wait.until(ExpectedConditions.alertIsPresent());

        Logs.info("Haciendo click en cancel en el alert/continue");
        alert.dismiss();

        Logs.info("Verificando que el div cancel sea visible");
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Cancel']")).isDisplayed());
    }

    @Test
    public void alert3Test() {
        Logs.info("Navegando a la página");
        driver.get("https://demoqa.com/alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        Logs.info("Esperando que cargue la página");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1[text()='Alerts']")));

        Logs.info("Haciendo click en el boton para que aparezca el prompt");
        driver.findElement(By.id("promtButton")).click();

        Logs.debug("Obteniendo el alert");
        final var alert = (Alert) wait.until(ExpectedConditions.alertIsPresent());

        final var faker = new Faker();
        final var randomName = faker.name().firstName();

        Logs.info("Escribiendo el nombre en el prompt");
        alert.sendKeys(randomName);

        Logs.info("Presionando accept en el alert");
        alert.accept();

        final var dynamicLocator = String.format("//span[text()='%s']", randomName);

        Logs.info("Verificando que el nombre sea visible");
        Assert.assertTrue(
                driver.findElement(By.xpath(dynamicLocator))
                        .isDisplayed()
        );
    }
}
