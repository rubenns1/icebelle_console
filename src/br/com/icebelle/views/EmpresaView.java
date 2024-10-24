package br.com.icebelle.views;

import br.com.icebelle.controllers.EmpresaController;
import br.com.icebelle.models.Empresa;

import java.util.List;
import java.util.Scanner;

public class EmpresaView {
    private Home home = new Home();
    private final Scanner scanner = new Scanner(System.in);
    private final Messages messages = new Messages();
    private final EmpresaController empresaController = new EmpresaController();

    public void telaEmpresaView() {
        messages.setInfo("\n[*] Cadastrar de Empresa\n\n");
        messages.setInfo("Nome da Empresa: ");
        Empresa empresa = new Empresa();
        empresa.setNome(scanner.nextLine());
        empresaController.adicionarEmpresaController(empresa.getId(), empresa.getNome());
        home.startApp();
    }

    public void listarEmpresasView() {
        int contador = 1;
        messages.setInfo("\n[*] Empresas Cadastradas\n\n");
        List<Empresa> empresas = empresaController.listarEmpresasController();
        for(Empresa empresa : empresas) {
            messages.setInfo("[" + contador + "] " + empresa.toString()+"\n");
            contador++;
        }
        home.startApp();
    }
}
