package br.com.icebelle.models;

import java.util.UUID;

public class Usuario{
    private String id;
    private int perfil;
    private String usuario;
    private String senha;

    public Usuario(){}

    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String id, int perfil, String usuario, String senha) {
        this.id = id;
        this.perfil = perfil;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
