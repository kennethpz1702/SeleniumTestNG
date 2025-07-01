package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class Footer extends BasePage {
    private final By twitterButton = By.xpath("//a[text()='Twitter']");
    private final By linkedButton = By.xpath("//a[text()='LinkedIn']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }


    @Step("Verificando los links de las redes sociales")
    public void verifySocialMediaLinks(
            String twitterUrl,
            String linkedinUrl,
            String facebookUrl
    ) {
        final var twitterLabel = find(twitterButton);
        final var linkedinLabel = find(linkedButton);
        final var facebookLabel = find(facebookButton);

        Logs.info("Verificando los links de las redes sociales");

        softAssert.assertTrue(twitterLabel.isDisplayed());
        softAssert.assertTrue(twitterLabel.isEnabled());
        softAssert.assertEquals(twitterLabel.getAttribute("href"), twitterUrl);

        softAssert.assertTrue(linkedinLabel.isDisplayed());
        softAssert.assertTrue(linkedinLabel.isEnabled());
        softAssert.assertEquals(linkedinLabel.getAttribute("href"), linkedinUrl);

        softAssert.assertTrue(facebookLabel.isDisplayed());
        softAssert.assertTrue(facebookLabel.isEnabled());
        softAssert.assertEquals(facebookLabel.getAttribute("href"), facebookUrl);

        softAssert.assertAll();
    }
}
