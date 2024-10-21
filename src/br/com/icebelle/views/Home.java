package br.com.icebelle.views;

import br.com.icebelle.controllers.LoginController;
import br.com.icebelle.models.Produtos;
import br.com.icebelle.models.ProdutosDAO;

import java.util.Date;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        ProdutosDAO<Object> produtosDAO = new ProdutosDAO<>();
        produtosDAO.adicionarProduto(new Produtos("Teste", 10, 1.90, "1547", new Date("10/10/2024"), new Date("10/10/2024")));
        produtosDAO.mostrarProdutos();

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
            Access access = new Access();
        } else {
            Messages messages = new Messages();
            messages.setFail("Falha ao logar-se no sistema, por favor tente novamente!\n");
            StartApp();
        }
        scanner.close();
    }
}
