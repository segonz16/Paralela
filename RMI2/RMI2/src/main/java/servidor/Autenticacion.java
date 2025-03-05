package servidor;

import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    private static final Map<String, String> usuarios = new HashMap<>();

    static {
        usuarios.put("admin", "1234");
        usuarios.put("usuario", "abcd");
    }

    public static boolean validarUsuario(String usuario, String password) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(password);
    }
}
