package br.com.icebelle.models;

import br.com.icebelle.views.Home;
import br.com.icebelle.views.Messages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;
    private final Messages messages = new Messages();

    public ProdutoDAO() {
        try{
            String url = "jdbc:mysql://localhost:3306/icebelle_homolog";
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
            messages.setSuccess("\n" +produto.getNome()+ " cadastrado com sucesso!\n");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Produto> listarProdutosDAO() {
        List<Produto> produtoList = new ArrayList<>();
        final String sql = "select produto from produtos order by produto";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("produto"));
                produtoList.add(produto);
            }

            statement.close();

        } catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        if(produtoList.isEmpty()){
            messages.setFail("Nenhum produto cadastrado.\n");
            Home home = new Home();
            home.startApp();
        }
        return produtoList;
    }

    public void excluiProdutoDAO(Produto produto) {
        String sql = "delete from produtos where nome = ?";
    }
}
