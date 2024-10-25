package br.com.icebelle.views;

import br.com.icebelle.controllers.ProdutoController;
import br.com.icebelle.models.Produto;
import br.com.icebelle.models.ProdutoDAO;

import java.util.Scanner;

public class Auth {
    private final Messages messages = new Messages();
    private final Scanner scanner = new Scanner(System.in);

    public Auth() {
        messages.setWarning("\n[*] Tela de autenticação\n\n");
        messages.setWarning("Login: ");
        scanner.next();
        messages.setWarning("Senha: ");
        scanner.next();
    }
}
