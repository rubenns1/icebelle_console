package br.com.icebelle.views;

import br.com.icebelle.controllers.EmpresaController;
import br.com.icebelle.models.Empresa;

import java.util.List;
import java.util.Scanner;

public class EmpresaView {
    private final Home home = new Home();
    private final Scanner scanner = new Scanner(System.in);
    private final Messages messages = new Messages();

    private final EmpresaController empresaController = new EmpresaController();

    public void telaEmpresaView() {
        messages.setInfo("\n[*] Cadastrar Empresa\n\n");
        messages.setInfo("Nome da Empresa: ");
        Empresa empresa = new Empresa();
        empresa.setNome(scanner.nextLine());
        empresaController.adicionarEmpresaController(empresa.getId(), empresa.getNome());
        home.startApp();
    }

    public void listarEmpresasView() {
        int contador = 0;
        messages.setInfo("\n[*] Empresas Cadastradas\n\n");
        List<Empresa> empresas = empresaController.listarEmpresasController();
        for(Empresa empresa : empresas) {
            messages.setInfo("[" + contador + "] " + empresa.toString()+"\n");
            contador++;
        }
        updateEmpresasView();
    }

    public void updateEmpresasView() {
        messages.setInfo("\nSelecione a empresa ou -1 para voltar: ");
        byte select = scanner.nextByte();
        if(select == -1) {
            home.startApp();
        } else {
            messages.setWarning(empresaController.listarEmpresasController().get(select).getNome() + " | 1 = Modificar, 2 = Excluir, 3 = Voltar menu\n");
            scanner.reset();
            messages.setWarning("Ação: ");
            int acao = scanner.nextInt();

            if (acao == 1) {
                messages.setInfo("Nome: ");

                Scanner sc = new Scanner(System.in);
                empresaController.updateEmpresasController(select, sc.nextLine());
                messages.setSuccess("Modificação concluída.\n");
                listarEmpresasView();
            } else if (acao == 2) {
                messages.setFail("Falha ao chamar uma nova tela.");
            } else if (acao == 3) {
                home.startApp();
            } else {
                throw new IllegalStateException("Unexpected value: " + acao);
            }
        }
    }
}
