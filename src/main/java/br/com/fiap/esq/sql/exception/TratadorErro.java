package br.com.fiap.esq.sql.exception;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

//Exibe uma mensagem adequada para cada tipo de erro que pode ocorrer nas views
public class TratadorErro {

    private TratadorErro() {}

    public static void exibir(Exception e) {
        if (e instanceof SQLException sql) {
            System.err.println("Erro de banco: " + TradutorErroOracle.descrever(sql));
        } else if (e instanceof EntidadeNaoEncontradaException) {
            System.err.println("Erro: " + e.getMessage());
        } else if (e instanceof NumberFormatException) {
            System.err.println("Valor numérico inválido");
        } else if (e instanceof DateTimeParseException) {
            System.err.println("Data inválida, use o formato aaaa-mm-dd");
        } else {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}
