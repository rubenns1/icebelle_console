package br.com.icebelle.models;

import java.util.UUID;

public class Produto {

    private String id;
    private String nome;

    public Produto(String nome) {
        this.id = getId();
        this.nome = nome;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }
}
