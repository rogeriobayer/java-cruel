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
    private Integer id;
    private Date dataHora;
    private String cpf;
    private double valor;
    private String justificativa;

    public RegistrarClienteBean() {
    }

    public RegistrarClienteBean(Integer id, String cpf, Date dataHora, double valor) {
        this.id = id;
        this.cpf = cpf;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

}

