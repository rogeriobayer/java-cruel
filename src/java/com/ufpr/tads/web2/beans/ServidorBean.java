/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.sql.Date;

/**
 *
 * @author anado
 */
public class ServidorBean extends CadastroBean {
    private String unidade;
    private Date data_ingresso;
    
    public ServidorBean(){
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(Date data_ingresso) {
        this.data_ingresso = data_ingresso;
    }
    
    
}
