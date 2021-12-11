/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.ClienteBean;
import com.ufpr.tads.web2.dao.acesso.ClienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class ClienteFacade {
    
    public ClienteFacade(){
    }
    
    public static ClienteBean buscar(ClienteBean cliente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDAO clienteDao = new ClienteDAO(conn.getConnection());
        return clienteDao.buscar(cliente);
    }

    public static List<ClienteBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDAO clienteDao = new ClienteDAO(conn.getConnection());
        return clienteDao.buscarTodos();
    }

    public static void inserir(ClienteBean cliente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDAO clienteDao = new ClienteDAO(conn.getConnection());
        clienteDao.inserir(cliente);
    }

    public static void remover(ClienteBean cliente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDAO clienteDao = new ClienteDAO(conn.getConnection());
        clienteDao.remover(cliente);
    } 
    
    public static void editar(ClienteBean cliente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDAO clienteDao = new ClienteDAO(conn.getConnection());
        clienteDao.editar(cliente);        
    }
}
