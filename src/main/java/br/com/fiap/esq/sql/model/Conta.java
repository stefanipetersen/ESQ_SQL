package br.com.fiap.esq.sql.model;

import java.math.BigDecimal;

public class Conta {

    private int idConta;
    private String nmConta;
    private String tpConta;
    private BigDecimal vlSaldoConta;
    private int idUsuario;

    public Conta() {}

    public Conta(int idConta, String nmConta, String tpConta, BigDecimal vlSaldoConta, int idUsuario) {
        this.idConta = idConta;
        this.nmConta = nmConta;
        this.tpConta = tpConta;
        this.vlSaldoConta = vlSaldoConta;
        this.idUsuario = idUsuario;
    }

    //Quando cadastrar não precisa criar o código, ele cria sozinho
    public Conta(String nmConta, String tpConta, BigDecimal vlSaldoConta, int idUsuario) {
        this.nmConta = nmConta;
        this.tpConta = tpConta;
        this.vlSaldoConta = vlSaldoConta;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", nmConta='" + nmConta + '\'' +
                ", tpConta='" + tpConta + '\'' +
                ", vlSaldoConta=" + vlSaldoConta +
                ", idUsuario=" + idUsuario +
                '}';
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNmConta() {
        return nmConta;
    }

    public void setNmConta(String nmConta) {
        this.nmConta = nmConta;
    }

    public String getTpConta() {
        return tpConta;
    }

    public void setTpConta(String tpConta) {
        this.tpConta = tpConta;
    }

    public BigDecimal getVlSaldoConta() {
        return vlSaldoConta;
    }

    public void setVlSaldoConta(BigDecimal vlSaldoConta) {
        this.vlSaldoConta = vlSaldoConta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
