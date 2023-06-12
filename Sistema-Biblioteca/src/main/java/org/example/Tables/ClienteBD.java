package org.example.Tables;

//Imports necessários
import org.example.Classes.Cliente;
import java.sql.SQLException;

public class ClienteBD extends ConexãoBD{

    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE CLIENTE NO DATABASE----------------------------
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

    //------------------------SELECIONAR CLIENTE POR CPF NO DATABASE----------------------------
    public boolean selectClienteCPF(String cpf) {

            connect();
            boolean verificado = false;

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
                verificado = false;
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

    //------------------------SELECIONAR NOME DE CLIENTE ESPECÌFICO NO DATABASE----------------------------
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


}
