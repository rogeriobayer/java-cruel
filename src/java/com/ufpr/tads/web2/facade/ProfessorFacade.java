/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.ProfessorBean;
import com.ufpr.tads.web2.dao.acesso.ProfessorDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class ProfessorFacade {
    
    public ProfessorFacade(){
    }
    
    public static ProfessorBean buscar(ProfessorBean professor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ProfessorDAO profDao = new ProfessorDAO(conn.getConnection());
        return profDao.buscar(professor);
    }

    public static List<ProfessorBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ProfessorDAO profDao = new ProfessorDAO(conn.getConnection());
        return profDao.buscarTodos();
    }

    public static void inserir(ProfessorBean professor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ProfessorDAO profDao = new ProfessorDAO(conn.getConnection());
        profDao.inserir(professor);
    }

    public static void remover(ProfessorBean professor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ProfessorDAO profDao = new ProfessorDAO(conn.getConnection());
        profDao.remover(professor);
    } 
    
        public static void editar(ProfessorBean professor) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        ProfessorDAO profDao = new ProfessorDAO(conn.getConnection());
        profDao.editar(professor);
    }
}
