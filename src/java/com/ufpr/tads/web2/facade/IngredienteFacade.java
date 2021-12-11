/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.IngredienteBean;
import com.ufpr.tads.web2.dao.acesso.IngredienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class IngredienteFacade {
    
    public IngredienteFacade(){
    }
    
    public static IngredienteBean buscar(IngredienteBean ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        return IngredienteDao.buscar(ingrediente);
    }

    public static List<IngredienteBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        return IngredienteDao.buscarTodos();
    }

    public static void inserir(IngredienteBean ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.inserir(ingrediente);
    }

    public static void remover(IngredienteBean ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.remover(ingrediente);
    }
    
    public static void editar(IngredienteBean ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.editar(ingrediente);  
    }
}
