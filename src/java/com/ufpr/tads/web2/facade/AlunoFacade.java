/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.AlunoBean;
import com.ufpr.tads.web2.dao.acesso.AlunoDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author anado
 */
public class AlunoFacade {
    
    public AlunoFacade(){
    }
    
    public static AlunoBean buscar(AlunoBean aluno) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AlunoDAO alunoDao = new AlunoDAO(conn.getConnection());
        return alunoDao.buscar(aluno);
    }

    public static List<AlunoBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AlunoDAO alunoDao = new AlunoDAO(conn.getConnection());
        return alunoDao.buscarTodos();
    }

    public static void inserir(AlunoBean aluno) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AlunoDAO alunoDao = new AlunoDAO(conn.getConnection());
        alunoDao.inserir(aluno);
    }

    public static void remover(AlunoBean aluno) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AlunoDAO alunoDao = new AlunoDAO(conn.getConnection());
        alunoDao.remover(aluno);
    } 
    
    public static void editar(AlunoBean aluno) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        AlunoDAO alunoDao = new AlunoDAO(conn.getConnection());
        alunoDao.editar(aluno);
    }
}
