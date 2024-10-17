package br.com.icebelle.views;

import br.com.icebelle.controllers.LoginController;

import java.util.Scanner;

public class Home {

    public static void main(String[] args) {
        Home home = new Home();
        home.StartApp();
    }

    public void StartApp(){
        Scanner scanner = new Scanner(System.in);
        LoginController loginController = new LoginController();

        System.out.print("\nDigite o username: ");
        String username = scanner.nextLine();

        System.out.print("Digite o password: ");
        String password = scanner.nextLine();

        if(loginController.login(username, password)){
            System.out.println("\nLogin bem sucedido!\n");
            Access access = new Access();
        } else {
            System.out.println("\nFalha ao logar-se no sistema, por favor tente novamente.");
            StartApp();
        }
        scanner.close();
    }
}
