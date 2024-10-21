package br.com.icebelle.models;

import java.util.UUID;

public class Clientes {
    private UUID id;
    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = getEmail();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = getTelefone();
    }

    public String getId() {
        this.id = UUID.randomUUID();
        return id.toString();
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
