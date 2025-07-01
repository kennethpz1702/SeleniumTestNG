package automation;

import Pages.Footer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;

public class FooterTests extends BaseTest {
    private final Footer footer = new Footer();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingPage();
    }

    @Test(groups = {regression})
    public void socialMediaLinksTest() {
        footer.verifySocialMediaLinks(
                "https://twitter.com/saucelabs",
                "https://www.linkedin.com/company/sauce-labs/",
                "https://www.facebook.com/saucelabs"
        );
    }
}
