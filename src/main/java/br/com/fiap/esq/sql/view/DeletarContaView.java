package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.ContaDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class DeletarContaView {

    public static void main(String[] args) {
        try (ContaDao dao = new ContaDao()) {
            dao.deletar(Leitor.lerInt("Digite o codigo da conta"));
            System.out.println("Conta removida");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
