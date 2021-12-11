/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.GerenteBean;
import com.ufpr.tads.web2.dao.acesso.GerenteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class GerenteFacade {
    
    public GerenteFacade(){
    }
    
    public static GerenteBean buscar(GerenteBean gerente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        GerenteDAO gerenteDao = new GerenteDAO(conn.getConnection());
        return gerenteDao.buscar(gerente);
    }

    public static List<GerenteBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        GerenteDAO gerenteDao = new GerenteDAO(conn.getConnection());
        return gerenteDao.buscarTodos();
    }

    public static void inserir(GerenteBean gerente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        GerenteDAO gerenteDao = new GerenteDAO(conn.getConnection());
        gerenteDao.inserir(gerente);
    }

    public static void remover(GerenteBean gerente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        GerenteDAO gerenteDao = new GerenteDAO(conn.getConnection());
        gerenteDao.remover(gerente);
    } 
    
    public static void editar(GerenteBean gerente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        GerenteDAO gerenteDao = new GerenteDAO(conn.getConnection());
        gerenteDao.editar(gerente);
    }
    
}

