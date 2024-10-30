package br.com.icebelle.views;

import br.com.icebelle.controllers.MenuController;
import br.com.icebelle.models.MenuDAO;

public class MenuView {
    private final MenuDAO menuDAO = new MenuDAO();

    public MenuView() {
        MenuController menuController = new MenuController(menuDAO);
    }
}
