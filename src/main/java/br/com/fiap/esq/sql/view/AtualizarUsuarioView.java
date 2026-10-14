package br.com.fiap.esq.sql.view;

import br.com.fiap.esq.sql.dao.UsuarioDao;
import br.com.fiap.esq.sql.exception.TratadorErro;
import br.com.fiap.esq.sql.model.Usuario;

import java.time.LocalDate;

public class AtualizarUsuarioView {

    public static void main(String[] args) {
        try (UsuarioDao dao = new UsuarioDao()) {
            int codigo = Leitor.lerInt("Digite o codigo do usuário");
            String nome = Leitor.lerTexto("Digite o seu nome completo");
            String email = Leitor.lerTexto("Digite o seu email");
            String senha = Leitor.lerTexto("Digite a sua senha");

            dao.atualizar(new Usuario(codigo, nome, email, senha, LocalDate.now()));
            System.out.println("Dados alterados com sucesso!");
        } catch (Exception e) {
            TratadorErro.exibir(e);
        }
    }
}
