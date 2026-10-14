package br.com.fiap.esq.sql.dao;

import br.com.fiap.esq.sql.exception.EntidadeNaoEncontradaException;
import br.com.fiap.esq.sql.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends BaseDao {

    public UsuarioDao() throws SQLException {
        super();
    }

    //Cadastrar um usuario no banco de dados
    public void insert(Usuario usuario) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(
                "insert into t_pfe_usuario (nm_usuario, ds_email, hash_senha, dt_cadastro)" +
                        " values ( ?, ?, ?, ?)")) {
            stmt.setString(1, usuario.getNmUsuario());
            stmt.setString(2, usuario.getDsEmail());
            stmt.setString(3, usuario.getHashSenha());
            stmt.setObject(4, usuario.getDtCadastro());
            stmt.executeUpdate();
        }
    }

    //Pesquisar Id do Usuário no banco de dados
    public Usuario pesquisarId(int idUsuario) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("select * from t_pfe_usuario where id_usuario = ?")) {
            stmt.setInt(1, idUsuario);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (!resultSet.next()) {
                    throw new EntidadeNaoEncontradaException("Usuário não encontrado");
                }
                return getUsuario(resultSet);
            }
        }
    }

    private static Usuario getUsuario(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_usuario");
        String nome = resultSet.getString("nm_usuario");
        String email = resultSet.getString("ds_email");
        String senha = resultSet.getString("hash_senha");
        LocalDate data = resultSet.getObject("dt_cadastro", LocalDate.class);
        return new Usuario(id, nome, email, senha, data);
    }

    //Listagem de usuarios do banco de dados
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("select * from T_PFE_USUARIO order by id_usuario");
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                lista.add(getUsuario(resultSet));
            }
        }
        return lista;
    }

    //Atualizar dados um usuario no banco de dados
    public void atualizar(Usuario usuario) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("update T_PFE_USUARIO set nm_usuario = ?" +
                ", ds_email = ?, hash_senha = ?, dt_cadastro = ? where id_usuario = ?")) {
            stmt.setString(1, usuario.getNmUsuario());
            stmt.setString(2, usuario.getDsEmail());
            stmt.setString(3, usuario.getHashSenha());
            stmt.setObject(4, usuario.getDtCadastro());
            stmt.setInt(5, usuario.getIdUsuario());
            int linhas = stmt.executeUpdate();

            //verifica a quantidade de linhas atualizadas
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Não possui usuário para atualizar");
        }
    }

    //Deletar dados no banco de dados
    public void deletar(int id) throws SQLException, EntidadeNaoEncontradaException {
        try (PreparedStatement stmt = connection.prepareStatement("delete from T_PFE_USUARIO where id_usuario = ?")) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas == 0)
                throw new EntidadeNaoEncontradaException("Id do usuário não encontrado para remoção");
        }
    }
}
