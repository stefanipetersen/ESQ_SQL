package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class PesquisaUsuarioView {

    public static void main(String[] args) {
        try (UsuarioDao dao = new UsuarioDao()) {
            System.out.println(dao.pesquisarId(Leitor.lerInt("Digite o codigo do usuário")));
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
