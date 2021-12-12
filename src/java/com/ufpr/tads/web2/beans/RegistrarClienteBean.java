/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author anado
 */
public class RegistrarClienteBean {
    private int id;
    private Date dataHora;
    private String cpf;
    private double valor;

    public RegistrarClienteBean() {
    }

    public RegistrarClienteBean(String cpf, Date dataHora, double valor) {
        this.cpf = cpf;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
