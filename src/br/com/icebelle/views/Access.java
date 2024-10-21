package br.com.icebelle.views;

import br.com.icebelle.controllers.EmpresasController;
import br.com.icebelle.models.Empresas;
import br.com.icebelle.models.Menu;
import br.com.icebelle.models.MenuDAO;

import java.util.Scanner;

public class Access {
        public Access() {
            Empresas empresas = new Empresas();
            Messages messages = new Messages();
            messages.setDefault("\n[*] Logado como administrador\n\n");
            MenuDAO menuDAO = new MenuDAO();
            menuDAO.MenuDAO();

            System.out.print("\nEscolha a opção para começar: ");
            Scanner scanner = new Scanner(System.in);

            Menu menu = new Menu();

            menu.setIdMenu(scanner.nextInt());

            if(menu.getIdMenu() == 1){
                CadastroEmpresas cadastroEmpresas = new CadastroEmpresas();
            } else if(menu.getIdMenu() == 2){
                EmpresasController empresasController = new EmpresasController();
                empresasController.ListarEmpresas();
            } else if(menu.getIdMenu() == 3){
                CadastroClientes cadastroClientes = new CadastroClientes();
            } else if(menu.getIdMenu() == 4){

            } else if(menu.getIdMenu() == 5){
                //
            } else if(menu.getIdMenu() == 6){
                //
            } else if(menu.getIdMenu() == 7){
                //
            } else if(menu.getIdMenu() == 9){
                messages.setWarning("Logoff realizado.\n\n");
                Home home = new Home();
                home.StartApp();
            }
        }
}
