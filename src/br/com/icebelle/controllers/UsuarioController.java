package br.com.icebelle.controllers;

import br.com.icebelle.models.Usuario;
import br.com.icebelle.models.UsuarioDAO;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public void adicionarUsuario(String id, int perfil, String login, String senha) {
        Usuario usuario = new Usuario(id, perfil, login, senha);
        usuarioDAO.adicionarUsuarioDAO(usuario);
    }
}
