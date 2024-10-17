package br.com.icebelle.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MenuDAO {

    private Map<Integer, String> menus = new HashMap<Integer, String>();

    public void MenuDAO() {
        menus.put(1, "1. Cadastrar Empresas");
        menus.put(2, "2. Listar Empresas");
        menus.put(3, "3. Cadastrar Clientes");
        menus.put(4, "4. Listar Clientes");
        menus.put(5, "5. Cadastrar Produtos");
        menus.put(6, "6. Listar Produtos");
        menus.put(7, "7. Listar Pendências");
        menus.put(8, "8. Desconectar-se");

        Iterator<String> stringIterator = menus.values().iterator();

        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }
}
