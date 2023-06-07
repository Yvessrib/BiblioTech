package org.example.Tables;

import java.sql.*;

public abstract class ConexãoBD {

    Connection connection;// Resposavel por fazer a conexao com o MySQL
    Statement statement;// Preparar as consultas do "SELECT"
    ResultSet resultSet;// Executar as consultas do "SELECT"
    PreparedStatement pst;// Reponsavel por preparar querys de manipalucao(INSERT, UPDATE, DELETE)

    static final String user = "root";
    static final String password = "1234";
    static final String database = "livraria";

    //url de conexao com o servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect(){
        try{
            connection = DriverManager.getConnection(url,user,password);
        }
        catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}
