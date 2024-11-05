package br.com.icebelle.views;

import br.com.icebelle.controllers.UsuarioController;
import br.com.icebelle.models.Usuario;

import java.util.Scanner;

public class UsuarioView {

    private Usuario usuario = new Usuario();
    private UsuarioController controller = new UsuarioController();
    private Messages messages = new Messages();
    public String valorUsuario;

    public UsuarioView(){}

    public void telaCadastroUsuario() {
        messages.setInfo("\n[+] Cadastro de Clientes\n");

        Scanner scanner = new Scanner(System.in);
        messages.setInfo("Perfil de usuário (0 = comum / 1 = admin): ");
        int perfil = scanner.nextInt();
        messages.setInfo("Login: ");
        String login = scanner.next();
        messages.setInfo("Senha: ");
        String senha = scanner.next();

        controller.adicionarUsuarioController(usuario.getId(), perfil, login, senha);
        messages.setSuccess("Notificação de cadastro enviada ao cliente.\n");
    }

    public boolean logarUsuario() {
        Scanner scanner = new Scanner(System.in);
        messages.setWarning("\n[+] Tela de Autenticação\n");
        messages.setWarning("Login: ");
        valorUsuario = scanner.nextLine();
        messages.setWarning("Senha: ");
        String senha = scanner.nextLine();
        UsuarioController usuarioController = new UsuarioController();
        return (usuarioController.loginController(valorUsuario, senha));
    }

    @Override
    public String toString() {
        return valorUsuario;
    }
}
