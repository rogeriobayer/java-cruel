/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.dto;

import com.ufpr.tads.web2.beans.RegistrarClienteBean;

/**
 *
 * @author drico
 */
public class RegistrarClienteDTO {
    private Integer id;
    private String dataHora;
    private String cpf;
    private String valor;

    public RegistrarClienteDTO(Integer id, String dataHora, String cpf, String valor){
        this.id = id;
        this.dataHora = dataHora;
        this.cpf = cpf;
        this.valor = valor;
    }
}
