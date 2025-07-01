package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {
    public static final String DP_CREDENTIALS = "dcCredentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {
        final var invalidas = DataGiver.getLockedCredentials();
        final var inexistentes = DataGiver.getUnexistentCredentials();

        return new Object[][]{
                {invalidas.getUsername(), invalidas.getPassword(), invalidas.getMessage()},
                {inexistentes.getUsername(), inexistentes.getPassword(), inexistentes.getMessage()}
        };
    }
}
