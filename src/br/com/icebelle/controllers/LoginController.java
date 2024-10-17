package br.com.icebelle.controllers;

import br.com.icebelle.models.UsuarioDAO;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean login(String login, String senha) {
        return usuarioDAO.autenticar(login, senha);
    }
}
