package br.com.icebelle.models;

import br.com.icebelle.views.Messages;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.executeUpdate();
            preparedStatement.close();
            messages.setSuccess("\n" +produto.getNome()+ " cadastrado com sucesso!\n\n");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Produto> listarProdutosDAO() {
        List<Produto> produtoList = new ArrayList<>();
        final String sql = "select id, nome from produtos order by nome";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("nome"));
                produtoList.add(produto);
            }
            statement.close();
        } catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        if(produtoList.isEmpty()){
            messages.setFail("Nenhum produto cadastrado.\n");
        }
        return produtoList;
    }

    public void excluiProdutoDAO(Produto produto) {
        String sql = "delete from produtos where nome = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            messages.setSuccess(produto.getNome()+ " excluido com sucesso!\n");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Produto> atualizarProdutoDAO(int index, String nome) {
        List<Produto> produtos = listarProdutosDAO();

        String sql = "update produtos set nome = ? where nome = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, produtos.get(index).getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return produtos;
    }
}
