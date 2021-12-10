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
public class AlunoBean extends CadastroBean {
    private String curso;
    private int ano;
    private String grr;
    
    public AlunoBean() {
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGrr() {
        return grr;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }
 
}
