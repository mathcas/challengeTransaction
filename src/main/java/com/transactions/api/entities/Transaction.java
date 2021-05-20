package com.transactions.api.entities;

import java.io.Serializable;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 7593564737592493019L;

    private String descricao;
    private long data;
    private int valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
