package com.ufpr.tads.web2.beans;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Refeicao {
    private int id;
    private String turno;
    private Cardapio cardapio;
    private ArrayList<Ingrediente> ingredientes;

    public Refeicao() {
    }

    public int getId() {
        return id;
    }

    public String getTurno() {
        return turno;
    }

    public Cardapio getCalendario() {
        return cardapio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setCalendario(Cardapio calendario) {
        this.cardapio = calendario;
    }
    
    
}
