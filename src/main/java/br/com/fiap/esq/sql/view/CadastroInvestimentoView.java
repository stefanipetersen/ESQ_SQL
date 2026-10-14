package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Investimento;

import java.time.LocalDate;

public class CadastroInvestimentoView {

    public static void main(String[] args) {
        try (InvestimentoDao dao = new InvestimentoDao()) {
            String tipo = Leitor.lerTexto("Digite o tipo do investimento (ex.: CDB, Tesouro Selic)");
            var valorInicial = Leitor.lerDecimal("Digite o valor inicial");
            var rendimento = Leitor.lerDecimalOpcional("Digite o rendimento (deixe vazio se não houver)");
            int idUsuario = Leitor.lerInt("Digite o codigo do usuário dono do investimento");

            dao.insert(new Investimento(tipo, valorInicial, rendimento, LocalDate.now(), idUsuario));
            System.out.println("Investimento cadastrado com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
