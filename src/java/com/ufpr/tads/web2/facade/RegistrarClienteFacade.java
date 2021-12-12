/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import com.ufpr.tads.web2.dao.acesso.RegistrarClienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;

/**
 *
 * @author drico
 */
public class RegistrarClienteFacade {

    public void registrarAtendimento(RegistrarClienteBean inputCliente) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RegistrarClienteDAO registrarClienteDAO = new RegistrarClienteDAO(connectionFactory.getConnection());
        registrarClienteDAO.registrarAtendimento(inputCliente);
    }
    
}
