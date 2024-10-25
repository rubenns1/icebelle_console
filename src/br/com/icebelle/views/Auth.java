package br.com.icebelle.views;

import java.util.Scanner;

public class Auth {
    public Auth() {
        Messages messages = new Messages();
        Scanner scanner = new Scanner(System.in);

        messages.setWarning("\n[*] Tela de autenticação\n\n");
        messages.setWarning("Login: ");
        scanner.next();
        messages.setWarning("Senha: ");
        scanner.next();
    }
}
