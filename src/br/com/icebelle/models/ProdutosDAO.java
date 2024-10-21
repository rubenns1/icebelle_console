package br.com.icebelle.models;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO <T> {
    private List<T> produtos;

    public ProdutosDAO() {
        this.produtos = new ArrayList<T>();
    }

    public void adicionarProduto(T produto) {
        produtos.add(produto);
    }

    public void mostrarProdutos(){
        for(T produto : produtos){
            System.out.println(produto);
        }
    }
}
