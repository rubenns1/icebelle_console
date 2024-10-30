package br.com.icebelle.controllers;
import br.com.icebelle.models.MenuDAO;

public class MenuController {
    private MenuDAO menuDAO = new MenuDAO();

    public MenuController(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}
