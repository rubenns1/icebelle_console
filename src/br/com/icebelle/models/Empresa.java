package br.com.icebelle.models;

import java.util.UUID;

public class Empresa {

    private String id;
    private String nome;

    public Empresa(){}

    public Empresa(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
