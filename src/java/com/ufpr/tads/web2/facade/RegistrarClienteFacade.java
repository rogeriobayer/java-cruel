/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import com.ufpr.tads.web2.dao.acesso.RegistrarClienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public List<RegistrarClienteBean> buscaRegistrosDia() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RegistrarClienteDAO registrarClienteDAO = new RegistrarClienteDAO(connectionFactory.getConnection());
        return registrarClienteDAO.buscarRegistrosDia(getDataAtualMeiaNoite(), getDataAtual2359()); 
    }
    
    public RegistrarClienteBean buscarRegistro(Integer id) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RegistrarClienteDAO registrarClienteDAO = new RegistrarClienteDAO(connectionFactory.getConnection());
        return registrarClienteDAO.buscarRegistro(id);
    }
    
    public void apagaRegistro(Integer id, String justificativa) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RegistrarClienteDAO registrarClienteDAO = new RegistrarClienteDAO(connectionFactory.getConnection());
        registrarClienteDAO.apagaRegistro(id, justificativa);
    }
    
    public void atualizaRegistro(RegistrarClienteBean inputCliente) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RegistrarClienteDAO registrarClienteDAO = new RegistrarClienteDAO(connectionFactory.getConnection());
        registrarClienteDAO.atualizaRegistro(inputCliente);
    }
    
    private Date getDataAtualMeiaNoite(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        
        return cal.getTime();
    }
    
        private Date getDataAtual2359(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cal.set(Calendar.MILLISECOND,999);
        
        return cal.getTime();
    }   
}
