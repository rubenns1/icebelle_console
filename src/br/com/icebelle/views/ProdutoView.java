package br.com.icebelle.views;

import br.com.icebelle.controllers.ProdutoController;
import br.com.icebelle.models.Produto;
import br.com.icebelle.models.ProdutoDAO;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {
    private final Messages messages = new Messages();
    private final Scanner scanner = new Scanner(System.in);
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final ProdutoController produtoController = new ProdutoController(produtoDAO);

    public void telaCadastroProdutoView() {
        messages.setInfo("\n[*] Tela Cadastro de Produtos\n\n");
        messages.setInfo("Nome: ");
        produtoController.adicionarProdutoController(scanner.nextLine());
    }

    public void listarProdutosView() {
        int index = 0;
        messages.setInfo("\n[*] Lista de Produtos\n\n");
        List<Produto> produtos = produtoController.listarProdutosController();
        for(Produto produto : produtos){
            System.out.println("[" + index++ + "] " + produto.toString());
        }
        atualizarProdutoView();
    }

    public void atualizarProdutoView() {
        messages.setWarning("Selecione um produto ou -1 para voltar: ");
        byte index = scanner.nextByte();
        if(index == -1){
            Home.main(null);
        } else if(index >= 0) {
            messages.setWarning(produtoController.listarProdutosController().get(index).toString() + " | 1 = Modificar | 2 = Excluir | 3 = Voltar\n");
            scanner.reset();
            messages.setWarning("Ação: ");
            int acao =  scanner.nextInt();
            if(acao == 1){
                messages.setWarning("Nome do produto: ");
                Scanner sc = new Scanner(System.in);
                String test = sc.nextLine();
                produtoController.atualizarProdutoController(index, test);
                messages.setSuccess("Atualização realizada.\n");
                listarProdutosView();
            } else if(acao == 2){
                excluirProdutoView(index);
                listarProdutosView();
            } else if(acao == 3){
                listarProdutosView();
            }
        }
    }

    public void excluirProdutoView(int index)
    {
        produtoController.excluirProdutoController(produtoDAO.listarProdutosDAO().get(index).toString());
    }
}
