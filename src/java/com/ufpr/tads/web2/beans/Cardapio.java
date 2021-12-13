package com.ufpr.tads.web2.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author julia
 */
public class Cardapio {
    private int id;
    private Date data;
    private int diaMes;
    private List<Refeicao> refeicoes;

    public Cardapio() {
    }

    public int getDiaMes() {
        return diaMes;
    }

    public void setDiaMes(int diaMes) {
        this.diaMes = diaMes;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
