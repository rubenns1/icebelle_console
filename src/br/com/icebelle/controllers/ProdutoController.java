package br.com.icebelle.controllers;

import br.com.icebelle.models.Produto;
import br.com.icebelle.models.ProdutoDAO;
import java.util.List;

public class ProdutoController {
    private final ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void adicionarProdutoController(String nome) {
        Produto produto = new Produto(nome);
        produtoDAO.adicionaProdutoDAO(produto);
    }

    public List<Produto> listarProdutosController() {
        Produto produto = new Produto();
        return produtoDAO.listarProdutosDAO();
    }

    public void excluirProdutoController(String nome) {
        Produto produto = new Produto(nome);
        produtoDAO.excluiProdutoDAO(produto);
    }

    public void atualizarProdutoController(int index, String nome) {
        //return produtoDAO.atualizarProdutoDAO(index, nome);
        produtoDAO.atualizarProdutoDAO(index, nome);

    }
}
