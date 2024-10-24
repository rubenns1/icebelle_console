package br.com.icebelle.controllers;

import br.com.icebelle.models.Empresa;
import br.com.icebelle.models.EmpresaDAO;

import java.util.List;

public class EmpresaController {

    private EmpresaDAO empresaDAO;

    public EmpresaController() {
        this.empresaDAO = new EmpresaDAO();
    }

    public void adicionarEmpresaController(String id, String nome) {
        Empresa empresa = new Empresa(id, nome);
        empresaDAO.cadastrarEmpresaDAO(empresa);
    }

    public List<Empresa> listarEmpresasController() {
        return empresaDAO.listarEmpresasDAO();
    }
}
