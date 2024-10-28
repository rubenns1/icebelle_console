package br.com.icebelle.models;

import br.com.icebelle.views.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuDAO {

    private final Map<Integer, String> menus = new HashMap<Integer, String>();
    private final Messages messages = new Messages();
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);

    public void menuUserDAO() {
        messages.setDefault("\n[*] Logado como usuário comum\n\n");
        menus.put(1, "1. Cadastrar Encomenda");
        menus.put(2, "2. Listar Encomendas");
        menus.put(3, "3. Listar Produtos");
        menus.put(4, "4. Desconectar-se");

        for (String s: menus.values()) {
            System.out.println(s);
        }

        messages.setDefault("\nEscolha uma opção para começar: ");
        menu.setIdMenu(scanner.nextInt());

        switch (menu.getIdMenu()) {
            case 1:
                //
            case 2:
                //
            case 3:
                //
        }
    }

    public void menuAdminDAO() {
        messages.setDefault("\n[*] Logado como administrador\n\n");
        menus.put(1, "1. Cadastrar Empresas");
        menus.put(2, "2. Listar Empresas");
        menus.put(3, "3. Cadastrar Clientes");
        menus.put(4, "4. Listar Clientes");
        menus.put(5, "5. Cadastrar Encomenda");
        menus.put(6, "6. Cadastrar Produtos");
        menus.put(7, "7. Listar Produtos");
        menus.put(8, "8. Listar Pendências");
        menus.put(9, "9. Desconectar-se");

        for (String s : menus.values()) {
            System.out.println(s);
        }

        messages.setDefault("\nEscolha uma opção para começar: ");
        menu.setIdMenu(scanner.nextInt());

        switch (menu.getIdMenu()) {
            case 1:
                EmpresaView cadastroEmpresaView = new EmpresaView();
                cadastroEmpresaView.telaEmpresaView();
                break;
            case 2:
                EmpresaView empresasView = new EmpresaView();
                empresasView.listarEmpresasView();
                break;
            case 3:
                UsuarioView usuarioView = new UsuarioView();
                break;
            case 6:
                ProdutoView produtoView = new ProdutoView();
                produtoView.telaProdutoView();
                break;
            case 7:
                ProdutoView produtosView = new ProdutoView();
                produtosView.listarProdutoView();
                break;
            case 9:
                Auth auth = new Auth();
                break;
            default:
                messages.setFail("Escolha inexistente: " + menu.getIdMenu() + ", tente novamente.\n");
                Home home = new Home();
                home.startApp();
                break;

        }
    }
}
