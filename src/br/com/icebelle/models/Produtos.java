package br.com.icebelle.models;
import java.util.Date;
import java.util.UUID;

public class Produtos {

    private UUID id;
    private String nome;
    private int quantidade;
    private double preco;
    private String lote;
    private Date dataCadastro;
    private Date dataValidade;

    public Produtos(String nome, int quantidade, double preco, String lote, Date dataCadastro, Date dataValidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.lote = lote;
        this.dataCadastro = dataCadastro;
        this.dataValidade = dataValidade;
    }

    public String getId() {
        this.id = UUID.randomUUID();
        return id.toString();
    }

    public void setId(String id) {
        this.id = UUID.fromString(getId());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return nome + quantidade + preco + lote;
    }
}
