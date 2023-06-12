package org.example.Tables;

import org.example.Classes.Cliente;
import org.example.Classes.Livro;
import org.example.Classes.Pedido;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivroBD extends ConexãoBD {

    boolean sucesso = false;

    //------------------------INSERIR NOVO LIVRO NO DATABASE----------------------------
    public boolean insertLivro(Livro livro) {

        connect();
        String sql = "INSERT INTO livro (idLivro,Título,AnoPubli,Preco,Editora_CNPJ) values (?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, livro.getId());
            pst.setString(2, livro.getTitulo());
            pst.setString(3, livro.getAnoPublicacao());
            pst.setDouble(4, livro.getPreco());
            pst.setInt(5, livro.getFk_Editora_CNPJ());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return sucesso;
    }

    //------------------------BUSCAR LIVROS NO DATABASE----------------------------
    public void selectLivro() {
        ArrayList<Livro> listaDeLivros = new ArrayList<>();

        connect();

        String sql = "SELECT * FROM livro";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {

                Livro livroTemp = new Livro(resultSet.getString("título"),resultSet.getString("anoPubli"),resultSet.getDouble("Preco"),resultSet.getInt("idLivro"),resultSet.getInt("Editora_CNPJ"));
                System.out.println("Id = " + livroTemp.getId());
                System.out.println("Título = " + livroTemp.getTitulo());
                System.out.println("Ano de publicação = " + livroTemp.getAnoPublicacao());
                System.out.println("Preco = " + livroTemp.getPreco());
                System.out.println("CNPJ da editora = " + livroTemp.getFk_Editora_CNPJ());
                System.out.println("---------------------------------");
                listaDeLivros.add(livroTemp);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
    }

    //------------------------BUSCAR LIVRO ESPECIFICO NO DATABASE----------------------------
    public boolean selectLivroId(int Id_Livro) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM livro WHERE idLivro = ?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Livro);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Livro livroTemp = new Livro(resultSet.getString("Título"), resultSet.getString("AnoPubli"), resultSet.getDouble("Preco"),resultSet.getInt("idLivro"),resultSet.getInt("Editora_CNPJ"));
                if(livroTemp.getId() == Id_Livro){
                    verificado = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }

    //------------------------BUSCAR LIVRO ESPECÍFICO NO DATABASE----------------------------
    public boolean selectLivroFromId(int Id_Livro) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM livro WHERE idLivro = ?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Livro);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Livro livroTemp = new Livro(resultSet.getString("Título"), resultSet.getString("AnoPubli"), resultSet.getDouble("Preco"),resultSet.getInt("idLivro"),resultSet.getInt("Editora_CNPJ"));
                if(livroTemp.getId() == Id_Livro){
                    System.out.println("Id = " + livroTemp.getId());
                    System.out.println("Título = " + livroTemp.getTitulo());
                    System.out.println("Ano de publicação = " + livroTemp.getAnoPublicacao());
                    System.out.println("Preco = " + livroTemp.getPreco());
                    System.out.println("CNPJ da editora = " + livroTemp.getFk_Editora_CNPJ());
                    System.out.println("---------------------------------");
                    verificado = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }

    //------------------------BUSCAR PREÇO DE LIVRO ESPECIFICO NO DATABASE----------------------------
    public double selectLivroPreco(int Id_Livro) {

        connect();

        double preco = 0;
        String sql = "SELECT * FROM livro where idLivro = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Livro);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Livro livroTemp = new Livro(resultSet.getString("Título"), resultSet.getString("AnoPubli"), resultSet.getDouble("Preco"),resultSet.getInt("idLivro"),resultSet.getInt("Editora_CNPJ"));
                preco = livroTemp.getPreco();
            }

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return preco;
    }


}
