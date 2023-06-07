package org.example.Tables;

import org.example.Classes.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ClienteBD extends ConexãoBD{

    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO NO DATABASE----------------------------
    public boolean insertCliente(Cliente cliente){

        connect();

        String sql = "INSERT INTO cliente (Nome,CPF,Telefone) values (?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cliente.getNome());
            pst.setString(2,cliente.getCPF());
            pst.setString(3,cliente.getTelefone());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex){
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }finally {
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
    public boolean deleteCliente(String cpf) {

        connect();

        String sql = "DELETE FROM cliente WHERE cpf=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
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

    //------------------------BUSCAR UM REGISTRO NO DATABASE----------------------------
    public ArrayList<Cliente> selectCliente() {
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();

        connect();

        String sql = "SELECT * FROM cliente";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de clientes: ");
            System.out.println();
            while (resultSet.next()) {
                Cliente clienteTemp = new Cliente(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("telefone"));
                System.out.println("Nome = " + clienteTemp.getNome());
                System.out.println("CPF = " + clienteTemp.getCPF());
                System.out.println("Telefone = " + clienteTemp.getTelefone());
                System.out.println("---------------------------------");
                listaDeClientes.add(clienteTemp);
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
        return listaDeClientes;
    }

    public boolean selectClienteCPF(String cpf) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM cliente";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {
                Cliente clienteTemp = new Cliente(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("telefone"));
                if(clienteTemp.getCPF().equals(cpf)) {
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

    public String selectClienteNome(String cpf) {

        connect();

        String nome = null;
        String sql = "SELECT * FROM cliente";

        try {

            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();

            while(resultSet.next()){
                Cliente clienteTemp = new Cliente(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("telefone"));

                if(clienteTemp.getCPF().equals(cpf)){
                    nome = clienteTemp.getNome();
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
        return nome;
    }

    //------------------------ATUALIZAR O NOME EM UM REGISTRO NO DATABASE----------------------------
    public boolean updateNomeCliente(String cpf, String novoNome) {

        connect();

        String sql = "UPDATE cliente SET nome=? WHERE cpf=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setString(2, cpf);
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

    public boolean updateTelefoneCliente(String cpf, String novoTelefone) {

        connect();

        String sql = "UPDATE cliente SET telefone=? WHERE cpf=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoTelefone);
            pst.setString(2, cpf);
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
}
