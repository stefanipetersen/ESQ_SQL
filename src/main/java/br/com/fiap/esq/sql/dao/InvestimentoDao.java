package br.com.fiap.esq.sql.dao;

import br.com.fiap.esq.sql.exception.EntidadeNaoEncontradaException;
import br.com.fiap.esq.sql.model.Investimento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao extends BaseDao {

    public InvestimentoDao() throws SQLException {
        super();
    }

    //Cadastrar um investimento no banco de dados
    public void insert(Investimento investimento) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(
                "insert into t_pfe_investimento (str_tipo, vl_inicial_investimento, vl_rendimento, dt_aplicacao, id_usuario)" +
                        " values (?, ?, ?, ?, ?)")) {
            stmt.setString(1, investimento.getStrTipo());
            stmt.setBigDecimal(2, investimento.getVlInicialInvestimento());
            stmt.setBigDecimal(3, investimento.getVlRendimento());
            stmt.setObject(4, investimento.getDtAplicacao());
            stmt.setInt(5, investimento.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    //Listagem de investimentos do banco de dados
    public List<Investimento> getAll() throws SQLException {
        List<Investimento> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("select * from t_pfe_investimento order by id_investimento");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Investimento(
                        rs.getInt("id_investimento"),
                        rs.getString("str_tipo"),
                        rs.getBigDecimal("vl_inicial_investimento"),
                        rs.getBigDecimal("vl_rendimento"),
                        rs.getObject("dt_aplicacao", LocalDate.class),
                        rs.getInt("id_usuario")));
            }
        }
        return lista;
    }

    //Pesquisar investimento pelo id no banco de dados
    public Investimento pesquisarId(int idInvestimento) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("select * from t_pfe_investimento where id_investimento = ?")) {
            stmt.setInt(1, idInvestimento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new EntidadeNaoEncontradaException("Investimento não encontrado");
                }
                return new Investimento(
                        rs.getInt("id_investimento"),
                        rs.getString("str_tipo"),
                        rs.getBigDecimal("vl_inicial_investimento"),
                        rs.getBigDecimal("vl_rendimento"),
                        rs.getObject("dt_aplicacao", LocalDate.class),
                        rs.getInt("id_usuario"));
            }
        }
    }

    //Atualizar dados de um investimento no banco de dados
    public void atualizar(Investimento investimento) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement(
                "update t_pfe_investimento set str_tipo = ?, vl_inicial_investimento = ?, vl_rendimento = ?," +
                        " dt_aplicacao = ?, id_usuario = ? where id_investimento = ?")) {
            stmt.setString(1, investimento.getStrTipo());
            stmt.setBigDecimal(2, investimento.getVlInicialInvestimento());
            stmt.setBigDecimal(3, investimento.getVlRendimento());
            stmt.setObject(4, investimento.getDtAplicacao());
            stmt.setInt(5, investimento.getIdUsuario());
            stmt.setInt(6, investimento.getIdInvestimento());
            int linhas = stmt.executeUpdate();

            //verifica a quantidade de linhas atualizadas
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Não possui investimento para atualizar");
        }
    }

    //Deletar um investimento do banco de dados
    public void deletar(int id) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("delete from t_pfe_investimento where id_investimento = ?")) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Id do investimento não encontrado para remoção");
        }
    }
}
