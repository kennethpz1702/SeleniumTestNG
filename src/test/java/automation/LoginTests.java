package automation;

import Pages.LoginPage;
import data.CustomDataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }
    

    @Test(
            groups = {regression},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.DP_CREDENTIALS)
    public void credentialesTest(String username, String password, String message) {
        loginPage.fillLogin(username, password);
        loginPage.verifyErrorMessage(message);
    }

    @Test(groups = {regression, smoke})
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }


}
