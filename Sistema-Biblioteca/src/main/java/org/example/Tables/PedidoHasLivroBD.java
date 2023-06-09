package org.example.Tables;

import org.example.Classes.Cliente;
import org.example.Classes.Livro;
import org.example.Classes.Pedido;

import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoHasLivroBD extends ConexãoBD{

    boolean sucesso = false;

    //------------------------INSERIR NOVO LIVRO NO PEDIDO NO DATABASE----------------------------
    public boolean insertLivroOnPedido(int Id_Livro,int Id_Pedido) {

        connect();
        String sql = "INSERT INTO pedido_has_livro (Livro_idLivro,Pedido_idPedido) values (?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Livro);
            pst.setInt(2, Id_Pedido);
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

    //------------------------DELETAR UM CLIENTE NO DATABASE----------------------------
    public boolean deleteLivroFromPedido(int Id_Livro,int Id_Pedido) {

        connect();
        boolean verifica;
        String sql = "DELETE FROM pedido_has_livro WHERE Livro_idLivro=? AND Pedido_idPedido=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Livro);
            pst.setInt(2, Id_Pedido);
            pst.execute();
            verifica = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            verifica = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verifica;
    }

    public int[] selectLivrosPedido(int idPedido) {

        int[] idLivros = new int[30];
        int i = 0;

        connect();

        String sql = "SELECT Livro_idLivro FROM pedido_has_livro WHERE Pedido_idPedido = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Livro livroTemp = new Livro(resultSet.getInt("Livro_idLivro"));
                idLivros[i] =  livroTemp.getId();
                i += 1;
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
        return idLivros;
    }
}
