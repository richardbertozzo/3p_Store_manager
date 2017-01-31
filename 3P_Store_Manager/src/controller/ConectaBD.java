package controller;

import java.sql.*;

public class ConectaBD {

    public ConectaBD() throws ClassNotFoundException {
        conexao();
    }

    public Connection conexao() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/3P_Store_Manager", "postgres", "1234");
     
            return conexao;
        } catch (SQLException e) {
            System.err.println("error:" + e);
            return null;
        }
    }

    public static void main(String[] args) {

    }

}
