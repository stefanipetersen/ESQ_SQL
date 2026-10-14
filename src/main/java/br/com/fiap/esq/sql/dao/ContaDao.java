package br.com.fiap.esq.sql.dao;

import br.com.fiap.esq.sql.exception.EntidadeNaoEncontradaException;
import br.com.fiap.esq.sql.model.Conta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao extends BaseDao {

    public ContaDao() throws SQLException {
        super();
    }

    //Cadastrar uma conta no banco de dados
    public void insert(Conta conta) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(
                "insert into t_pfe_conta (nm_conta, tp_conta, vl_saldo_conta, id_usuario) values (?, ?, ?, ?)")) {
            stmt.setString(1, conta.getNmConta());
            stmt.setString(2, conta.getTpConta());
            stmt.setBigDecimal(3, conta.getVlSaldoConta());
            stmt.setInt(4, conta.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    //Listagem de contas do banco de dados
    public List<Conta> getAll() throws SQLException {
        List<Conta> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("select * from t_pfe_conta order by id_conta");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Conta(
                        rs.getInt("id_conta"),
                        rs.getString("nm_conta"),
                        rs.getString("tp_conta"),
                        rs.getBigDecimal("vl_saldo_conta"),
                        rs.getInt("id_usuario")));
            }
        }
        return lista;
    }

    //Pesquisar conta pelo id no banco de dados
    public Conta pesquisarId(int idConta) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("select * from t_pfe_conta where id_conta = ?")) {
            stmt.setInt(1, idConta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new EntidadeNaoEncontradaException("Conta não encontrada");
                }
                return new Conta(
                        rs.getInt("id_conta"),
                        rs.getString("nm_conta"),
                        rs.getString("tp_conta"),
                        rs.getBigDecimal("vl_saldo_conta"),
                        rs.getInt("id_usuario"));
            }
        }
    }

    //Atualizar dados de uma conta no banco de dados
    public void atualizar(Conta conta) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement(
                "update t_pfe_conta set nm_conta = ?, tp_conta = ?, vl_saldo_conta = ?, id_usuario = ? where id_conta = ?")) {
            stmt.setString(1, conta.getNmConta());
            stmt.setString(2, conta.getTpConta());
            stmt.setBigDecimal(3, conta.getVlSaldoConta());
            stmt.setInt(4, conta.getIdUsuario());
            stmt.setInt(5, conta.getIdConta());
            int linhas = stmt.executeUpdate();

            //verifica a quantidade de linhas atualizadas
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Não possui conta para atualizar");
        }
    }

    //Deletar uma conta do banco de dados
    public void deletar(int id) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("delete from t_pfe_conta where id_conta = ?")) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Id da conta não encontrado para remoção");
        }
    }
}
