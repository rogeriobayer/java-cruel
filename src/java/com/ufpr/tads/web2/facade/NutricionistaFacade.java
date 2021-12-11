/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.NutricionistaBean;
import com.ufpr.tads.web2.dao.acesso.NutricionistaDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class NutricionistaFacade {
    
    public NutricionistaFacade(){
    }
    
    public static NutricionistaBean buscar(NutricionistaBean nutricionista) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        NutricionistaDAO nutriDao = new NutricionistaDAO(conn.getConnection());
        return nutriDao.buscar(nutricionista);
    }

    public static List<NutricionistaBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        NutricionistaDAO nutriDao = new NutricionistaDAO(conn.getConnection());
        return nutriDao.buscarTodos();
    }

    public static void inserir(NutricionistaBean nutricionista) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        NutricionistaDAO nutriDao = new NutricionistaDAO(conn.getConnection());
        nutriDao.inserir(nutricionista);
    }

    public static void remover(NutricionistaBean nutricionista) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        NutricionistaDAO nutriDao = new NutricionistaDAO(conn.getConnection());
        nutriDao.remover(nutricionista);
    } 
    
    public static void editar(NutricionistaBean nutricionista) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        NutricionistaDAO nutriDao = new NutricionistaDAO(conn.getConnection());
        nutriDao.editar(nutricionista);   
    }
}
