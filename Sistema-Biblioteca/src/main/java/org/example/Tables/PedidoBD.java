package org.example.Tables;

import org.example.Classes.Pedido;

import java.sql.SQLException;


public class PedidoBD extends ConexãoBD {

    boolean sucesso = false;

    //------------------------INSERIR NOVO PEDIDO NO DATABASE----------------------------
    public boolean insertPedido(Pedido pedido) {

        connect();
        String sql = "INSERT INTO pedido (idPedido,Cliente_CPF,dataPedido,'Processando') values (?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pedido.getPk_idPedido());
            pst.setString(2, pedido.getFk_Cliente_CPF());
            pst.setString(3, pedido.getDataPedido());
            pst.setString(4, pedido.getStatusPedido());
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

    public boolean selectPedidoId(int Id_Pedido) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM pedido";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("Cliente_CPF"), resultSet.getString("dataPedido"),resultSet.getString("statusPedido"));
                if (pedidoTemp.getPk_idPedido() == Id_Pedido) {
                    verificado = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }

    //------------------------BUSCAR UM REGISTRO NO DATABASE----------------------------
    public boolean selectPedidosIDs(String Cliente_CPF) {

        connect();

        boolean verificado = false;
        String sql = "SELECT * FROM pedido WHERE Cliente_CPF=?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, Cliente_CPF);
            resultSet = pst.executeQuery();

            System.out.println("Lista de Id's de pedidos desta conta: ");
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("Cliente_CPF"), resultSet.getString("dataPedido"),resultSet.getString("statusPedido"));
                System.out.println("Id: " + pedidoTemp.getPk_idPedido());
            }
            verificado = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            verificado = false;
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

    public void selectInfosPedidos(int idPedido) {

        connect();

        boolean verificado;

        String sql = "SELECT * FROM pedido WHERE idPedido = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("Cliente_CPF"), resultSet.getString("dataPedido"), resultSet.getString("statusPedido"));
                System.out.println("Data do pedido: " + pedidoTemp.getDataPedido());
                System.out.println("Status do pedido: " + pedidoTemp.getStatusPedido());
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
    }

    //------------------------DELETAR UM CLIENTE NO DATABASE----------------------------
    public boolean deletePedido(int idPedido) {

        connect();

        String sql = "DELETE FROM pedido WHERE idPedido=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    public boolean updateStatusPedido(int Id_pedido) {

        connect();
        boolean validado;
        String sql = "UPDATE pedido SET statusPedido='Pagamento realizado' WHERE idPedido=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_pedido);
            pst.execute();
            validado = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            validado = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return validado;
    }

}


