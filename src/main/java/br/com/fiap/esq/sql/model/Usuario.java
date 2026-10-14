package br.com.fiap.esq.sql.model;

import java.time.LocalDate;

public class Usuario {

    private int idUsuario;
    private String nmUsuario;
    private String dsEmail;
    private String hashSenha;
    private LocalDate dtCadastro;

    public Usuario() {}

    public Usuario(int idUsuario, String nmUsuario, String dsEmail, String hashSenha, LocalDate dtCadastro) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.hashSenha = hashSenha;
        this.dtCadastro = dtCadastro;
    }

    public Usuario(String nmUsuario, String dsEmail, String hashSenha, LocalDate dtCadastro) {
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.hashSenha = hashSenha;
        this.dtCadastro = dtCadastro;
    }

    //Quando cadastrar não precisa criar o código, ele cria sozinho
    public Usuario(String nmUsuario, String dsEmail, String hashSenha) {
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.hashSenha = hashSenha;
        this.dtCadastro = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nmUsuario='" + nmUsuario + '\'' +
                ", dsEmail='" + dsEmail + '\'' +
                ", hashSenha='" + hashSenha + '\'' +
                ", dtCadastro=" + dtCadastro +
                '}';
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
