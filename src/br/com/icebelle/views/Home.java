package br.com.icebelle.views;

import br.com.icebelle.controllers.MenuController;

public class Home {
    public static void main(String[] args) {
        Home home = new Home();
        home.startApp();
    }

    public void startApp() {
        MenuController menuController = new MenuController();
    }
}
