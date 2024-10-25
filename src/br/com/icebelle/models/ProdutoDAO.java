package br.com.icebelle.models;

import br.com.icebelle.views.Messages;

import java.sql.*;

public class ProdutoDAO {

    private Connection connection;
    private final Messages messages = new Messages();

    public ProdutoDAO() {
        try{
            String url = "jdbc:mysql://localhost:3306/icebelle_homolog_v2";
            String user = "root";
            String senha = null;

            connection = DriverManager.getConnection(url, user, senha);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void adicionaProdutoDAO(Produto produto) {
        String sql = "insert into produtos(id, nome) values(?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.execute();
            preparedStatement.close();
            messages.setSuccess("\n" +produto.getNome()+ " cadastrado com sucesso!\n");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
