package br.com.icebelle.views;

import br.com.icebelle.controllers.EmpresasController;
import br.com.icebelle.models.Empresas;
import java.util.Scanner;

public class CadastroEmpresas {

    public CadastroEmpresas() {
        Messages messages = new Messages();
        messages.setInfo("\n[*] Cadastrar nova empresa\n");

        System.out.print("Digite o nome do empresa: ");
        Scanner scanner = new Scanner(System.in);

        Empresas empresas = new Empresas();
        empresas.setNome(scanner.nextLine());

        EmpresasController empresasController = new EmpresasController();
        empresasController.CadastrarEmpresas(empresas);

        Access access = new Access();
    }
}
