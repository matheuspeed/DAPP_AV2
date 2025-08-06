package com.example.av2;

import java.io.Serializable;

public class Filme implements Serializable {
    private String nome;
    private int ano;
    private String ra;

    public Filme(String nome, int ano, String ra) {
        this.nome = nome;
        this.ano = ano;
        this.ra = ra;
    }

    public Filme() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}
