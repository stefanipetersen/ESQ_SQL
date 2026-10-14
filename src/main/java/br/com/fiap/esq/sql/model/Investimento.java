package br.com.fiap.esq.sql.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investimento {

    private int idInvestimento;
    private String strTipo;
    private BigDecimal vlInicialInvestimento;
    private BigDecimal vlRendimento;
    private LocalDate dtAplicacao;
    private int idUsuario;

    public Investimento() {}

    public Investimento(int idInvestimento, String strTipo, BigDecimal vlInicialInvestimento,
                        BigDecimal vlRendimento, LocalDate dtAplicacao, int idUsuario) {
        this.idInvestimento = idInvestimento;
        this.strTipo = strTipo;
        this.vlInicialInvestimento = vlInicialInvestimento;
        this.vlRendimento = vlRendimento;
        this.dtAplicacao = dtAplicacao;
        this.idUsuario = idUsuario;
    }

    //Quando cadastrar não precisa criar o código, ele cria sozinho
    public Investimento(String strTipo, BigDecimal vlInicialInvestimento,
                        BigDecimal vlRendimento, LocalDate dtAplicacao, int idUsuario) {
        this.strTipo = strTipo;
        this.vlInicialInvestimento = vlInicialInvestimento;
        this.vlRendimento = vlRendimento;
        this.dtAplicacao = dtAplicacao;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Investimento{" +
                "idInvestimento=" + idInvestimento +
                ", strTipo='" + strTipo + '\'' +
                ", vlInicialInvestimento=" + vlInicialInvestimento +
                ", vlRendimento=" + vlRendimento +
                ", dtAplicacao=" + dtAplicacao +
                ", idUsuario=" + idUsuario +
                '}';
    }

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getStrTipo() {
        return strTipo;
    }

    public void setStrTipo(String strTipo) {
        this.strTipo = strTipo;
    }

    public BigDecimal getVlInicialInvestimento() {
        return vlInicialInvestimento;
    }

    public void setVlInicialInvestimento(BigDecimal vlInicialInvestimento) {
        this.vlInicialInvestimento = vlInicialInvestimento;
    }

    public BigDecimal getVlRendimento() {
        return vlRendimento;
    }

    public void setVlRendimento(BigDecimal vlRendimento) {
        this.vlRendimento = vlRendimento;
    }

    public LocalDate getDtAplicacao() {
        return dtAplicacao;
    }

    public void setDtAplicacao(LocalDate dtAplicacao) {
        this.dtAplicacao = dtAplicacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
