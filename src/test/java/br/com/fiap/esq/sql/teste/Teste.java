package br.com.fiap.esq.sql.teste;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.EntidadeNaoEncontradaException;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Conta;
import br.com.fiap.esq.sql.model.Investimento;
import br.com.fiap.esq.sql.model.Usuario;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

//Classe de testes: insere 5 registros em cada entidade e depois consulta com getAll
public class Teste {

    private static final int QUANTIDADE = 5;

    @FunctionalInterface
    private interface Etapa {
        void executar() throws Exception;
    }

    public static void main(String[] args) {
        executar("USUARIO", Teste::testarUsuario);
        executar("CONTA", Teste::testarConta);
        executar("INVESTIMENTO", Teste::testarInvestimento);
    }

    //Executa uma etapa e trata qualquer erro de banco
    private static void executar(String titulo, Etapa etapa) {
        System.out.println("=== " + titulo + " ===");
        try {
            etapa.executar();
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }

    private static void testarUsuario() throws SQLException {
        try (UsuarioDao dao = new UsuarioDao()) {
            long sufixo = System.currentTimeMillis();
            for (int i = 1; i <= QUANTIDADE; i++) {
                dao.insert(new Usuario("Usuario Teste " + i, "teste" + i + "_" + sufixo + "@email.com", "hash" + i));
            }
            System.out.println(QUANTIDADE + " usuários cadastrados.");

            dao.getAll().forEach(System.out::println);
        }
    }

    private static void testarConta() throws SQLException, EntidadeNaoEncontradaException {
        int idUsuario = obterIdUsuario();
        String[] tipos = {"Corrente", "Poupanca", "Corrente", "Salario", "Poupanca"};

        try (ContaDao dao = new ContaDao()) {
            for (int i = 0; i < QUANTIDADE; i++) {
                BigDecimal saldo = new BigDecimal("1000.50").add(BigDecimal.valueOf(i * 100));
                dao.insert(new Conta("Conta Teste " + (i + 1), tipos[i], saldo, idUsuario));
            }
            System.out.println(QUANTIDADE + " contas cadastradas.");

            dao.getAll().forEach(System.out::println);
        }
    }

    private static void testarInvestimento() throws SQLException, EntidadeNaoEncontradaException {
        int idUsuario = obterIdUsuario();
        String[] tipos = {"CDB", "Tesouro Selic", "LCI", "Acoes", "Fundo Imobiliario"};

        try (InvestimentoDao dao = new InvestimentoDao()) {
            for (int i = 0; i < QUANTIDADE; i++) {
                BigDecimal valorInicial = new BigDecimal("500.00").add(BigDecimal.valueOf(i * 250));
                BigDecimal rendimento = i % 2 == 0 ? new BigDecimal("12.75") : null;
                dao.insert(new Investimento(tipos[i], valorInicial, rendimento, LocalDate.now().minusMonths(i), idUsuario));
            }
            System.out.println(QUANTIDADE + " investimentos cadastrados.");

            dao.getAll().forEach(System.out::println);
        }
    }

    //Conta e investimento precisam de um usuário existente por causa da chave estrangeira
    private static int obterIdUsuario() throws SQLException, EntidadeNaoEncontradaException {
        try (UsuarioDao dao = new UsuarioDao()) {
            return dao.getAll().stream()
                    .findFirst()
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhum usuário cadastrado para vincular os registros"))
                    .getIdUsuario();
        }
    }
}
