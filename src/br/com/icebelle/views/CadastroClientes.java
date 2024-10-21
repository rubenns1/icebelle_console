package br.com.icebelle.views;

import br.com.icebelle.controllers.ClientesController;
import br.com.icebelle.models.Clientes;

import java.util.Scanner;

public class CadastroClientes {
    public CadastroClientes() {
        Messages messages = new Messages();
        Clientes cliente = new Clientes();

        messages.setInfo("\n[*] Cadastro de Clientes\n");

        Scanner scanner = new Scanner(System.in);
        messages.setInfo("Nome do Cliente: ");
        cliente.setNome(scanner.nextLine());

        messages.setInfo("Telefone do Cliente: ");
        cliente.setTelefone(scanner.nextLine());

        messages.setInfo("Email do Cliente: ");
        cliente.setEmail(scanner.nextLine());
        cliente.setLogin(cliente.getEmail());
        cliente.setSenha(cliente.getSenha());

        ClientesController clientesController = new ClientesController(cliente);
    }
}
