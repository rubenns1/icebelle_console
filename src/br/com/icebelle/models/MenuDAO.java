package br.com.icebelle.models;

import java.util.HashMap;
import java.util.Map;

public class MenuDAO {

    private final Map<Integer, String> menus = new HashMap<Integer, String>();

    public void MenuDAO() {
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
    }
}
