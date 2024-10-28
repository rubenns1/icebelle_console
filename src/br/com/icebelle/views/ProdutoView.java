package br.com.icebelle.views;

import br.com.icebelle.controllers.ProdutoController;
import br.com.icebelle.models.Produto;
import br.com.icebelle.models.ProdutoDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProdutoView {
    private final Messages messages = new Messages();
    private final Scanner scanner = new Scanner(System.in);
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final ProdutoController produtoController = new ProdutoController(produtoDAO);

    public void telaProdutoView() {
        messages.setInfo("\n[*] Tela Cadastro de Produtos\n\n");
        messages.setInfo("Nome: ");
        produtoController.adicionarProdutoController(scanner.nextLine());
        Home home = new Home();
        home.startApp();
    }

    public void listarProdutoView() {
        int contador = 0;
        messages.setInfo("\n[*] Lista de Produtos\n\n");
        List<Produto> produtos = produtoController.listarProdutosController();
        for(Produto produto : produtos){
            System.out.println("[" + contador++ + "] " + produto.toString());
        }

        messages.setWarning("Selecione um produto ou -1 para voltar: ");
        int selecao = scanner.nextInt();
        messages.setFail(String.valueOf(selecao));
        if(selecao >= 0){
            messages.setFail("Falha.");

            Calendar calendar = Calendar.getInstance();
        }
    }
}
