package br.com.icebelle.models;
import java.util.UUID;

public class Empresas {
    private UUID id;
    private String nome;

    public String getId() {
        this.id = UUID.randomUUID();
        return id.toString();
    }

    public void setId(String id) {
        this.id = UUID.fromString(getId());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
