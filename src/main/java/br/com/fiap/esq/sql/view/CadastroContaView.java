package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Conta;

public class CadastroContaView {

    public static void main(String[] args) {
        try (ContaDao dao = new ContaDao()) {
            String nome = Leitor.lerTexto("Digite o nome da conta");
            String tipo = Leitor.lerTexto("Digite o tipo da conta (ex.: Corrente, Poupanca)");
            var saldo = Leitor.lerDecimal("Digite o saldo da conta");
            int idUsuario = Leitor.lerInt("Digite o codigo do usuário dono da conta");

            dao.insert(new Conta(nome, tipo, saldo, idUsuario));
            System.out.println("Conta cadastrada com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
