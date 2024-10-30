package br.com.icebelle.models;

import br.com.icebelle.controllers.MenuController;
import br.com.icebelle.views.Home;
import br.com.icebelle.views.Messages;

import javax.swing.*;
import java.sql.*;

public class UsuarioDAO {
    private Connection connection;
    private final Messages messages = new Messages();
    private final MenuDAO menuDAO = new MenuDAO();

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

    public void adicionarUsuarioDAO(Usuario usuario) {
        String sql = "insert into users(id, perfil, login, senha) values(?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getId());
            preparedStatement.setInt(2, usuario.getPerfil());
            preparedStatement.setString(3, usuario.getUsuario());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.executeUpdate();
            messages.setSuccess("\n" + usuario.getUsuario() + " cadastrado com sucesso.\n");
            connection.close();
        } catch (SQLException sqlException) {
            messages.setFail("\nFalha: " + sqlException.getMessage() + ", tente novamente.\n\n");
        }
    }

    public void loginDAO(String login, String senha) {
        String sql = "select perfil, login, senha from users where login = ? and senha = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int perfil = resultSet.getInt("perfil");
            login = resultSet.getString("login");
            senha = resultSet.getString("senha");

            if(perfil == 1 && login.equals(login) && senha.equals(senha)){
                messages.setSuccess("\n" + login + " (administrador) logado com sucesso.\n");
                messages.setFail(String.valueOf(perfil));
                menuDAO.menuAdminDAO();
            } else if(perfil == 0 && login.equals(login) && senha.equals(senha)){
                messages.setSuccess("\n" + login + " (cliente) logado com sucesso.\n");
                messages.setFail(String.valueOf(perfil));
                menuDAO.menuUserDAO();
            } else{
                messages.setFail("Falha ao logar-se");
            }

        } catch(SQLException sqlException) {
            messages.setFail("Falha ao logar-se\n");
            Home.main(null);
        }
    }
}
