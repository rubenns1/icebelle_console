package br.com.icebelle.controllers;

import br.com.icebelle.models.Clientes;
import br.com.icebelle.views.Access;
import br.com.icebelle.views.Messages;

public class ClientesController {
    public ClientesController(Clientes clientes) {
        Messages msg = new Messages();
        msg.setSuccess("\nCliente cadastrado com sucesso, informações de acesso enviada via e-mail.\n");
        Access access = new Access();
    }
}
