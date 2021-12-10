/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author anado
 */
public class ProfessorBean extends CadastroBean {
    private String depto;
    private String area_estudo;
    
    public ProfessorBean(){
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getArea_estudo() {
        return area_estudo;
    }

    public void setArea_estudo(String area_estudo) {
        this.area_estudo = area_estudo;
    }
    
    
    
}
