package br.com.icebelle.models;

import br.com.icebelle.views.Home;
import br.com.icebelle.views.Messages;
import java.sql.*;

public class UsuarioDAO {
    private Connection connection;
    private final Messages messages = new Messages();
    private final MenuDAO menuDAO = new MenuDAO();

    public UsuarioDAO() {
        try {
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
            preparedStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            messages.setFail("\nFalha: " + sqlException.getMessage() + ", tente novamente.\n\n");
        }
    }

    public void loginDAO(String login, String senha) {
        String sql = "select perfil, login, senha from users where login = ? and senha = ?";
        String sqlUpdate = "update users set logado = ? where login = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int perfil = resultSet.getInt("perfil");
            login = resultSet.getString("login");
            senha = resultSet.getString("senha");

            preparedStatementUpdate.setInt(1, 1);
            preparedStatementUpdate.setString(2, login);
            preparedStatementUpdate.executeUpdate();
            preparedStatementUpdate.close();
            connection.close();

            if(perfil == 1 && login.equals(login) && senha.equals(senha)){
                messages.setSuccess(login + " (administrador) logado com sucesso.\n\n");
                menuDAO.menuAdminDAO();
            } else if(perfil == 0 && login.equals(login) && senha.equals(senha)){
                messages.setSuccess(login + " (cliente) logado com sucesso.\n\n");
                menuDAO.menuUserDAO();
            } else if (perfil == 3 && login.equals(login) && senha.equals(senha)){
                messages.setSuccess(login + "(outro) logado com sucesso.\n\n");
            } else {
                messages.setFail("Falha ao logar-se\n");
            }
        } catch(SQLException sqlException) {
            messages.setFail("Falha ao logar-se\n");
            Home.main(null);
        }
    }
}
