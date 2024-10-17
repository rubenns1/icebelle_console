package br.com.icebelle.views;

import br.com.icebelle.models.Menu;
import br.com.icebelle.models.MenuDAO;

import java.util.Scanner;

public class Access {
        public Access(){
            System.out.println("[*] Logado como administrador\n");
            MenuDAO menuDAO = new MenuDAO();
            menuDAO.MenuDAO();

            System.out.print("\nEscolha a opção para começar: ");
            Scanner scanner = new Scanner(System.in);

            Menu menu = new Menu();

            menu.setIdMenu(scanner.nextInt());

            if(menu.getIdMenu() == 1){
                CadastroEmpresas cadastroEmpresas = new CadastroEmpresas();
            } else if(menu.getIdMenu() == 2){
                //Chamar tela para cadastrar clientes.
            } else if(menu.getIdMenu() == 3){
                //Chamar tela para cadastrar produtos.
            } else if(menu.getIdMenu() == 4){
                //Chamar tela inicial/principal.
            } else if(menu.getIdMenu() == 5){
                //
            } else if(menu.getIdMenu() == 6){
                //
            } else if(menu.getIdMenu() == 7){
                //
            } else if(menu.getIdMenu() == 8){
                Messages messages = new Messages("\n[*] Logoff realizado com sucesso!");
                Home home = new Home();
                home.StartApp();
            }
        }
}
