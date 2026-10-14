package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Investimento;

public class AtualizarInvestimentoView {

    public static void main(String[] args) {
        try (InvestimentoDao dao = new InvestimentoDao()) {
            int codigo = Leitor.lerInt("Digite o codigo do investimento");
            String tipo = Leitor.lerTexto("Digite o tipo do investimento (ex.: CDB, Tesouro Selic)");
            var valorInicial = Leitor.lerDecimal("Digite o valor inicial");
            var rendimento = Leitor.lerDecimalOpcional("Digite o rendimento (deixe vazio se não houver)");
            var data = Leitor.lerData("Digite a data da aplicação (aaaa-mm-dd)");
            int idUsuario = Leitor.lerInt("Digite o codigo do usuário dono do investimento");

            dao.atualizar(new Investimento(codigo, tipo, valorInicial, rendimento, data, idUsuario));
            System.out.println("Dados alterados com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
