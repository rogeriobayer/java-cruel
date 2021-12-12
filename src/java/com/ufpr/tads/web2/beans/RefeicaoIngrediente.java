/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author julia
 */
public class RefeicaoIngrediente {
    private int id;
    private int idRefeicao;
    private int idIngrediente;
    private String nome;
    private int quantidade;

    public RefeicaoIngrediente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public int getId() {
        return id;
    }

    public int getIdRefeicao() {
        return idRefeicao;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdRefeicao(int idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
