package br.com.icebelle.controllers;

import br.com.icebelle.models.Empresas;
import br.com.icebelle.views.Messages;

import java.util.HashMap;
import java.util.Map;

public class EmpresasController {
    private Empresas empresas = new Empresas();
    private Map<String, String> map = new HashMap<>();
    Messages messages = new Messages();

    public void CadastrarEmpresas(Empresas empresas){
        map.put("UUID", empresas.getId());
        map.put("Nome", empresas.getNome());

        messages.setSuccess("\n[" + empresas.getId() + "]" + "[" + empresas.getNome() + "] " + "cadastrada com sucesso!\n");
    }

    public void ListarEmpresas(){
        map.get("UUID");
        map.put("Nome", empresas.getNome());
    }
}
