package br.com.fiap.esq.sql.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe responsável por criar as conexões com o banco de dados
public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        Connection conexao = DriverManager
                .getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                "rm572254", "FIAP#2026");
        return conexao;
    }
}
