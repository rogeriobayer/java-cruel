/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.ExternoBean;
import com.ufpr.tads.web2.dao.acesso.ExternoDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class ExternoFacade {
    
    public ExternoFacade(){
    }
    
    public static ExternoBean buscar(ExternoBean externo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ExternoDAO externoDao = new ExternoDAO(conn.getConnection());
        return externoDao.buscar(externo);
    }

    public static List<ExternoBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ExternoDAO externoDao = new ExternoDAO(conn.getConnection());
        return externoDao.buscarTodos();
    }

    public static void inserir(ExternoBean externo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ExternoDAO externoDao = new ExternoDAO(conn.getConnection());
        externoDao.inserir(externo);
    }

    public static void remover(ExternoBean externo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ExternoDAO externoDao = new ExternoDAO(conn.getConnection());
        externoDao.remover(externo);
    } 
    
    public static void editar(ExternoBean externo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ExternoDAO externoDao = new ExternoDAO(conn.getConnection());
        externoDao.editar(externo);   
    }
}
