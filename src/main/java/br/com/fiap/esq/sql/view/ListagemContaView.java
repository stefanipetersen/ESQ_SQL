package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class ListagemContaView {

    public static void main(String[] args) {
        try (ContaDao dao = new ContaDao()) {
            dao.getAll().forEach(System.out::println);
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
