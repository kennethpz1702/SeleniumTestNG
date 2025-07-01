package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final static int defaultTimeout = 10;
    protected final SoftAssert softAssert;
    private final int timeOut;

    public BasePage(int timeOut) {
        softAssert = new SoftAssert();
        this.timeOut = timeOut;
    }

    public BasePage() {
        this(defaultTimeout); //Llamo al constructor de arriba con el default timeOut

    }

    protected WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    protected void waitPage(By locator, String pagename) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        Logs.info("Esperando que la pagina %s carge", pagename);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        Logs.info("%s ha cargado satisfactoriamente", pagename);
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public abstract void waitPageToLoad();// Esperar que cargue la pagina

    public abstract void verifyPage(); //Verificar la UI de la paginaa
}
