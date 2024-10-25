package br.com.icebelle.views;

import br.com.icebelle.controllers.ProdutoController;
import br.com.icebelle.models.ProdutoDAO;

import java.util.Scanner;

public class ProdutoView {
    private final Messages messages = new Messages();
    private final Scanner scanner = new Scanner(System.in);
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public void telaProdutoView() {
        messages.setInfo("\n[*] Tela Cadastro de Produtos\n\n");
        messages.setInfo("Nome: ");
        ProdutoController produtoController = new ProdutoController(produtoDAO);
        produtoController.adicionarProdutoController(scanner.nextLine());
        Home home = new Home();
        home.startApp();
    }
}
