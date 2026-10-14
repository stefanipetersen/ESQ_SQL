package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class PesquisaContaView {

    public static void main(String[] args) {
        try (ContaDao dao = new ContaDao()) {
            System.out.println(dao.pesquisarId(Leitor.lerInt("Digite o codigo da conta")));
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
