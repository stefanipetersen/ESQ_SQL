package br.com.fiap.esq.sql.exception;

import java.sql.SQLException;

//Códigos de erro mais comuns do Oracle
public class TradutorErroOracle {

    private TradutorErroOracle() {}

    public static String descrever(SQLException e) {
        String causa = switch (e.getErrorCode()) {
            case 942 -> "Tabela ou view não existe (ORA-00942)";
            case 1 -> "Registro duplicado, violação de unique, ex.: e-mail já cadastrado (ORA-00001)";
            case 2291 -> "Chave estrangeira inválida, o usuário informado não existe (ORA-02291)";
            case 1400 -> "Campo obrigatório não informado (ORA-01400)";
            case 12541, 17002 -> "Banco indisponível ou sem conexão (ORA-" + e.getErrorCode() + ")";
            default -> "Código " + e.getErrorCode();
        };
        return causa + " - " + e.getMessage();
    }
}
