package br.com.icebelle.views;
import br.com.icebelle.models.MenuDAO;

import java.sql.*;

public class Home {

    private static int perfil;
    private static boolean logado;

    private final static MenuDAO menuDAO = new MenuDAO();
    private final static UsuarioView usuarioView = new UsuarioView();
    private static Connection connection;

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/icebelle_homolog_v2";
            String user = "root";
            String senha = null;

            connection = DriverManager.getConnection(url, user, senha);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try {
            String sql = "select perfil, logado from users where login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuarioView.valorUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            perfil = resultSet.getInt("perfil");
            logado = resultSet.getBoolean("logado");

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(logado == true && perfil == 1) {
            menuDAO.menuAdminDAO();
        } else if(logado == true && perfil == 0) {
            menuDAO.menuUserDAO();
        } else if(logado == true && perfil == 3) {
            // Chamar menu confeiteiro
        } else if(logado == false && perfil < 0) {
            usuarioView.logarUsuario();
        } else if(logado == false && perfil > 0) {
            usuarioView.logarUsuario();
        }
    }
}
