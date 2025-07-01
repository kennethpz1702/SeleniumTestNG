package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CredencialJson {
    @JsonProperty("credentials")
    private Map<String, Credencial> mapCredencales;

    public Map<String, Credencial> getMapCredenciales() {
        return mapCredencales;
    }
}
