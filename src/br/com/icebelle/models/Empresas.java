package br.com.icebelle.models;

import java.util.Random;

public class Empresas {

    private static int id = 1;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id += id;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
