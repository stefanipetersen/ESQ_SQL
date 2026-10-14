package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Conta;

public class AtualizarContaView {

    public static void main(String[] args) {
        try (ContaDao dao = new ContaDao()) {
            int codigo = Leitor.lerInt("Digite o codigo da conta");
            String nome = Leitor.lerTexto("Digite o nome da conta");
            String tipo = Leitor.lerTexto("Digite o tipo da conta (ex.: Corrente, Poupanca)");
            var saldo = Leitor.lerDecimal("Digite o saldo da conta");
            int idUsuario = Leitor.lerInt("Digite o codigo do usuário dono da conta");

            dao.atualizar(new Conta(codigo, nome, tipo, saldo, idUsuario));
            System.out.println("Dados alterados com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
