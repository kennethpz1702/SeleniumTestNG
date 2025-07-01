package data;

import modelos.Credencial;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credencial> obtenerMapCredenciales() {
        return JsonReader.obtenerMapCredenciales().getMapCredenciales();
    }

    public static Credencial getValidCredentials() {
        return obtenerMapCredenciales().get("valid");
    }

    public static Credencial getLockedCredentials() {
        return obtenerMapCredenciales().get("locked");
    }

    //Unexistente
    public static Credencial getUnexistentCredentials() {
        return obtenerMapCredenciales().get("unexistent");
    }
}
