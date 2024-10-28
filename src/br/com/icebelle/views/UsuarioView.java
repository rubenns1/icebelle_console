package br.com.icebelle.views;

import br.com.icebelle.controllers.UsuarioController;
import br.com.icebelle.models.Usuario;

import java.util.Scanner;

public class UsuarioView {

    private Home home = new Home();
    private Usuario usuario = new Usuario();
    private UsuarioController controller = new UsuarioController();
    private Messages messages;

    public UsuarioView() {
        messages = new Messages();
        messages.setInfo("\n[+] Cadastro de Clientes\n");

        Scanner scanner = new Scanner(System.in);
        messages.setInfo("Perfil de usuário (0 = comum / 1 = admin): ");
        int perfil = scanner.nextInt();
        messages.setInfo("Login: ");
        String login = scanner.next();
        messages.setInfo("Senha: ");
        String senha = scanner.next();

        controller.adicionarUsuarioController(usuario.getId(), perfil, login, senha);
        home.startApp();
    }
}
