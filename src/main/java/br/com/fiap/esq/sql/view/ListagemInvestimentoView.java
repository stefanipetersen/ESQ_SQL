package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.InvestimentoDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class ListagemInvestimentoView {

    public static void main(String[] args) {
        try (InvestimentoDao dao = new InvestimentoDao()) {
            dao.getAll().forEach(System.out::println);
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
