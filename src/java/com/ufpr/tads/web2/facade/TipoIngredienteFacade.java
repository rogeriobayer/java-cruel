/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.TipoIngredienteBean;
import com.ufpr.tads.web2.dao.acesso.TipoIngredienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class TipoIngredienteFacade {
    
    public TipoIngredienteFacade(){
    }
    
    public static TipoIngredienteBean buscar(TipoIngredienteBean tipo  ) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        return TipoIngredienteDao.buscar(tipo  );
    }

    public static List<TipoIngredienteBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        return TipoIngredienteDao.buscarTodos();
    }

    public static void inserir(TipoIngredienteBean tipo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        TipoIngredienteDao.inserir(tipo);
    }

    public static void remover(TipoIngredienteBean tipo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        TipoIngredienteDao.remover(tipo);
    } 
    
    public static void editar(TipoIngredienteBean tipo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        TipoIngredienteDao.remover(tipo);   
    }
}
