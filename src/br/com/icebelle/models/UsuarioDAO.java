package br.com.icebelle.models;

import br.com.icebelle.views.Messages;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    private Connection connection;
    private Usuario usuario;
    private Map<String, String> map = new HashMap<>();
    private final Messages messages = new Messages();

    public UsuarioDAO() {
        try{
            String url = "jdbc:mysql://localhost:3306/icebelle_homolog_v2";
            String user = "root";
            String senha = null;

            connection = DriverManager.getConnection(url, user, senha);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void adicionarUsuario(Usuario usuario) {
        String sql = "insert into users(id, perfil, login, senha) values(?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getId());
            preparedStatement.setInt(2, usuario.getPerfil());
            preparedStatement.setString(3, usuario.getUsuario());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.executeUpdate();
            messages.setSuccess("\n" + usuario.getUsuario() + " cadastrado com sucesso.\n");
        } catch (SQLException sqlException) {
            messages.setFail("\nFalha: " + sqlException.getMessage() + ", tente novamente.\n\n");
        }
    }
}
