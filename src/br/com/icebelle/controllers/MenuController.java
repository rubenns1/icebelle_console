package br.com.icebelle.controllers;

import br.com.icebelle.models.Menu;
import br.com.icebelle.models.MenuDAO;

public class MenuController {
    private final MenuDAO menuDAO = new MenuDAO();

    public MenuController(){
        menuDAO.menuAdminDAO();
    }
}
