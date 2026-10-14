package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Usuario;

public class CadastroUsuarioView {

    public static void main(String[] args) {
        try (UsuarioDao dao = new UsuarioDao()) {
            String nome = Leitor.lerTexto("Digite o seu nome completo");
            String email = Leitor.lerTexto("Digite o seu email");
            String senha = Leitor.lerTexto("Digite a sua senha");

            dao.insert(new Usuario(nome, email, senha));
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
