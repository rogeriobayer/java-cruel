/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Ingrediente;
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
    
    public static Ingrediente buscar(Integer id) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        return IngredienteDao.buscar(id);
    }

    public static List<Ingrediente> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        return IngredienteDao.buscarTodos();
    }

    public static void inserir(Ingrediente ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.inserir(ingrediente);
    }

    public static void remover(Integer id) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.remover(id);
    }
    
    public static void editar(Ingrediente ingrediente) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        IngredienteDAO IngredienteDao = new IngredienteDAO(conn.getConnection());
        IngredienteDao.editar(ingrediente);  
    }
}
