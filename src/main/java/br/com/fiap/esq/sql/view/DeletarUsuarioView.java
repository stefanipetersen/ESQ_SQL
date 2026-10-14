package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.TratadorErro;

public class DeletarUsuarioView {

    public static void main(String[] args) {
        try (UsuarioDao dao = new UsuarioDao()) {
            dao.deletar(Leitor.lerInt("Digite o codigo do usuário"));
            System.out.println("Usuário removido");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
