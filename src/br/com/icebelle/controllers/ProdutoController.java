package br.com.icebelle.controllers;

import br.com.icebelle.models.Produto;
import br.com.icebelle.models.ProdutoDAO;
import br.com.icebelle.views.ProdutoView;

public class ProdutoController {
    private ProdutoDAO produtoDAO;
    private ProdutoView produtoView;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void adicionarProdutoController(String nome) {
        Produto produto = new Produto(nome);
        produtoDAO.adicionaProdutoDAO(produto);
    }
}
