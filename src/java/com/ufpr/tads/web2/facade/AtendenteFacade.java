/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.AtendenteBean;
import com.ufpr.tads.web2.dao.acesso.AtendenteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class AtendenteFacade {
    
    public AtendenteFacade(){
    }
    
    public static AtendenteBean buscar(AtendenteBean atendente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AtendenteDAO atendDao = new AtendenteDAO(conn.getConnection());
        return atendDao.buscar(atendente);
    }

    public static List<AtendenteBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AtendenteDAO atendDao = new AtendenteDAO(conn.getConnection());
        return atendDao.buscarTodos();
    }

    public static void inserir(AtendenteBean atendente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AtendenteDAO atendDao = new AtendenteDAO(conn.getConnection());
        atendDao.inserir(atendente);
    }

    public static void remover(AtendenteBean atendente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AtendenteDAO atendDao = new AtendenteDAO(conn.getConnection());
        atendDao.remover(atendente);
    } 
    
    public static void editar(AtendenteBean atendente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AtendenteDAO atendDao = new AtendenteDAO(conn.getConnection());
        atendDao.editar(atendente);
    }
}