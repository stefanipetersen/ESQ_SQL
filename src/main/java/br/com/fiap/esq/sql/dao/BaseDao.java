package br.com.fiap.esq.sql.dao;

import br.com.fiap.esq.sql.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

//Classe base dos DAOs: abre a conexão no construtor e fecha no close (permite try-with-resources)
public abstract class BaseDao implements AutoCloseable {

    protected final Connection connection;

    protected BaseDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
