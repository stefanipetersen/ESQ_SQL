package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class DeletarInvestimentoView {

    public static void main(String[] args) {
        try (InvestimentoDao dao = new InvestimentoDao()) {
            dao.deletar(Leitor.lerInt("Digite o codigo do investimento"));
            System.out.println("Investimento removido");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
