package br.com.icebelle.views;

import br.com.icebelle.models.Empresas;

import java.io.*;
import java.util.Scanner;

public class CadastroEmpresas {

    public CadastroEmpresas() {
        System.out.println("\n[*] Cadastrar nova empresa");
        System.out.print("Nome da Empresa: ");
        Scanner scanner = new Scanner(System.in);

        Empresas empresas = new Empresas();
        empresas.setNome(scanner.nextLine());

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\icebelle_homolog\\cadastros\\empresas\\empresas.txt", true));
            bufferedWriter.write(empresas.getId() + "|" + empresas.getNome());
            bufferedWriter.newLine();
            bufferedWriter.close();
            Messages messages = new Messages("\n[" + empresas.getNome() + "]" +" cadastrado com sucesso!\n");

            Access access = new Access();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
