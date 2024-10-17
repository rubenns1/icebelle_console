package br.com.icebelle.models;

public class Usuario {

    private int perfil;
    private String usuario;
    private String senha;

    public Usuario(int perfil, String usuario, String senha) {
        this.perfil = perfil;
        this.usuario = usuario;
        this.senha = senha;
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
