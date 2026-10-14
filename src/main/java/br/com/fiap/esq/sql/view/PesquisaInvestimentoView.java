package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class PesquisaInvestimentoView {

    public static void main(String[] args) {
        try (InvestimentoDao dao = new InvestimentoDao()) {
            System.out.println(dao.pesquisarId(Leitor.lerInt("Digite o codigo do investimento")));
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
