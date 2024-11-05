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
    private final EmpresaView empresaView = new EmpresaView();
    private final ProdutoView produtoView = new ProdutoView();


    public void menuUserDAO() {
        messages.setDefault("");
        menus.put(1, "1. Cadastrar Encomenda");
        menus.put(2, "2. Listar Encomendas");
        menus.put(3, "3. Listar Produtos");
        menus.put(4, "4. Desconectar-se");

        for (String s: menus.values()) {
            System.out.println(s);
        }

        messages.setDefault("\nEscolha uma opção para começar: ");
        menu.setIdMenu(scanner.nextInt());

        if(menu.getIdMenu() == 1) {
            // cad_encomenda
        } else if(menu.getIdMenu() == 2) {
            // list_encomenda
        } else if(menu.getIdMenu() == 3) {
            ProdutoView produto = new ProdutoView();
            produto.listarProdutosView();
        } else if(menu.getIdMenu() == 4) {
            Home.main(null);
        }
    }


    public void menuAdminDAO() {
        messages.setDefault("");
        menus.put(1, "1. Cadastrar Empresas");
        menus.put(2, "2. Listar Empresas");
        menus.put(3, "3. Cadastrar Clientes");
        menus.put(4, "4. Listar Clientes");
        menus.put(5, "5. Cadastrar Encomenda");
        menus.put(6, "6. Listar Encomendas");
        menus.put(7, "7. Cadastrar Produtos");
        menus.put(8, "8. Listar Produtos");
        menus.put(9, "9. Listar Pendências");
        menus.put(10, "10. Desconectar-se");

        for (String s : menus.values()) {
            System.out.println(s);
        }

        messages.setDefault("\nEscolha uma opção para começar: ");
        menu.setIdMenu(scanner.nextInt());

        if(menu.getIdMenu() == 1) {
            empresaView.telaEmpresaView();
        } else if(menu.getIdMenu() == 2) {
            empresaView.listarEmpresasView();
        } else if(menu.getIdMenu() == 3) {
            UsuarioView usuarioView = new UsuarioView();
            usuarioView.telaCadastroUsuario();
        } else if(menu.getIdMenu() == 4) {
            //list_clientes
        } else if(menu.getIdMenu() == 5) {
            // cad_encomenda
        } else if(menu.getIdMenu() == 6) {
            // list_encomenda
        } else if(menu.getIdMenu() == 7) {
            produtoView.telaCadastroProdutoView();
        } else if(menu.getIdMenu() == 8) {
            produtoView.listarProdutosView();
        } else if(menu.getIdMenu() == 9) {
            //list_pendencias
        } else if(menu.getIdMenu() == 10) {
            Home.main(null);
        }
    }
}
