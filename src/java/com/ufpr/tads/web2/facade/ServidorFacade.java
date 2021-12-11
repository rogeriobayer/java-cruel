/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.ServidorBean;
import com.ufpr.tads.web2.dao.acesso.ServidorDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class ServidorFacade {
    
    public ServidorFacade(){
    }
    
    public static ServidorBean buscar(ServidorBean servidor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ServidorDAO servidorDao = new ServidorDAO(conn.getConnection());
        return servidorDao.buscar(servidor);
    }

    public static List<ServidorBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ServidorDAO servidorDao = new ServidorDAO(conn.getConnection());
        return servidorDao.buscarTodos();
    }

    public static void inserir(ServidorBean servidor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ServidorDAO servidorDao = new ServidorDAO(conn.getConnection());
        servidorDao.inserir(servidor);
    }

    public static void remover(ServidorBean servidor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ServidorDAO servidorDao = new ServidorDAO(conn.getConnection());
        servidorDao.remover(servidor);
    }
    
    public static void editar(ServidorBean servidor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ServidorDAO servidorDao = new ServidorDAO(conn.getConnection());
        servidorDao.editar(servidor);
    }
}
