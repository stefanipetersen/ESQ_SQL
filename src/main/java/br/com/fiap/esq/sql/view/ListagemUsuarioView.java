package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class ListagemUsuarioView {

    public static void main(String[] args) {
        try (UsuarioDao dao = new UsuarioDao()) {
            dao.getAll().forEach(System.out::println);
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
