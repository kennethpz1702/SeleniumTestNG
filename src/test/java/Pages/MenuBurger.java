package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class MenuBurger extends BasePage {
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");

    @Override
    @Step("Esperando que el menu burger aparezca")
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getSimpleName());

        Logs.info("Esperando que sea clickeable por la animacion");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Override
    @Step("Verificando el menu burger")
    public void verifyPage() {
        Logs.info("Verificando el menun burger");
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertTrue(find(aboutButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Haciendo click en logout")
    public void clickLogout() {
        Logs.info("Haciendo click en logout");
        find(logoutButton).click();
    }

    @Step("Verificando la opcion de about")
    public void verifyAboutLink(String expectedUrl) {
        final var aboutLabel = find(aboutButton);

        Logs.info("Verificando la opcion de about");

        softAssert.assertTrue(aboutLabel.isDisplayed());
        softAssert.assertTrue(aboutLabel.isEnabled());
        softAssert.assertEquals(aboutLabel.getAttribute("href"), expectedUrl);
        softAssert.assertAll();

    }
}
