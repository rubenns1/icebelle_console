package br.com.icebelle.models;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    private Map<String, String> usuarios = new HashMap<>();

    public UsuarioDAO() {
        usuarios.put("rubens.silva", "toor");
        usuarios.put("admin", "admin");
    }

    public boolean autenticar(String username, String senha) {
        return usuarios.containsKey(username) && usuarios.get(username).equals(senha);
    }
}
