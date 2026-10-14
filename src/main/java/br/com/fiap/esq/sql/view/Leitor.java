package br.com.fiap.esq.sql.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

//Leitura de dados do teclado, usada por todas as views
//Valores inválidos lançam NumberFormatException ou DateTimeParseException, tratadas pelo TratadorErro
public class Leitor {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Leitor() {}

    public static String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return SCANNER.nextLine();
    }

    public static int lerInt(String mensagem) {
        return Integer.parseInt(lerTexto(mensagem).trim());
    }

    public static BigDecimal lerDecimal(String mensagem) {
        return new BigDecimal(lerTexto(mensagem).trim().replace(',', '.'));
    }

    //Retorna null quando nada é digitado
    public static BigDecimal lerDecimalOpcional(String mensagem) {
        String entrada = lerTexto(mensagem).trim();
        return entrada.isEmpty() ? null : new BigDecimal(entrada.replace(',', '.'));
    }

    public static LocalDate lerData(String mensagem) {
        return LocalDate.parse(lerTexto(mensagem).trim());
    }
}
