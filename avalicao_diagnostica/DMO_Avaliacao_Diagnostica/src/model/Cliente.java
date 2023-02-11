package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente{

    private long identificador;
    private String nome;
    private String telefone;
    private String email;

    private List<Conta> contas;

    public Cliente(long identificador, String nome, String telefone, String email) {
        this.identificador = identificador;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        contas = new ArrayList<>();
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Conta> getContas() {
        return contas;
    }

}