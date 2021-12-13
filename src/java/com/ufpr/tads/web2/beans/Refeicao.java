package com.ufpr.tads.web2.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class Refeicao {
    private int id;
    private String turno;
    private Cardapio cardapio;
    private List<RefeicaoIngrediente> refIng;

    public Refeicao() {
    }

    public int getId() {
        return id;
    }

    public String getTurno() {
        return turno;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public List<RefeicaoIngrediente> getRefIng() {
        return refIng;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setRefIng(List<RefeicaoIngrediente> refIng) {
        this.refIng = refIng;
    }
    
    
    
    
    
}
