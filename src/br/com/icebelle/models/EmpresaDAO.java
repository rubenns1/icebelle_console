package br.com.icebelle.models;

import br.com.icebelle.views.Messages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private Messages messages = new Messages();
    private Connection connection;

    public EmpresaDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/icebelle_homolog_v2";
            String usuario = "root";
            String senha = null;

            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void cadastrarEmpresaDAO(Empresa empresa) {
        final String sql = "insert into empresa(id, nome) values(?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empresa.getId());
            preparedStatement.setString(2, empresa.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            messages.setSuccess(empresa.getNome() + " cadastrada com sucesso.\n");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void excluirEmpresaDAO(String nome) {
        final String sql = "delete from empresa where nome = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            messages.setSuccess("Exclusão realizada com sucesso.\n");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Empresa> listarEmpresasDAO() {
        List<Empresa> empresas = new ArrayList<>();
        final String sql = "select id, nome from empresa order by nome";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Empresa empresa = new Empresa();
                empresa.setId(resultSet.getString("id"));
                empresa.setNome(resultSet.getString("nome"));
                empresas.add(empresa);
            }
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(empresas.isEmpty()) {
            messages.setFail("Nenhuma empresa cadastrada.");
        }

        return empresas;
    }

    public List<Empresa> updateEmpresasDAO(int select, String value) {
        List<Empresa> empresas = listarEmpresasDAO();

        String sql = "update empresa set nome = ? where nome = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, listarEmpresasDAO().get(select).getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            messages.setFail("Falha: " + sqlException.getMessage());
        }

        if(empresas.isEmpty()) {
            messages.setFail("Nenhuma empresa cadastrada.");
        }
        return empresas;
    }


}
