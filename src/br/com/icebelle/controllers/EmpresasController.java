package br.com.icebelle.controllers;

import br.com.icebelle.models.Empresas;

public class EmpresasController {
    private Empresas empresas;

    public void CadastrarEmpresas(Empresas empresas) {
        this.empresas = new Empresas();

        System.out.println("[" + empresas.getNome() + "] " + "cadastrada com sucesso!");
    }
}
