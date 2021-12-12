/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Refeicao;
import com.ufpr.tads.web2.dao.acesso.RefeicaoDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import exceptions.DAOException;
import exceptions.FacadeException;
import java.util.List;

/**
 *
 * @author julia
 */
public class RefeicaoFacade {
    
     public static List<Refeicao> buscar(int id) throws FacadeException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            RefeicaoDAO bd = new RefeicaoDAO(factory.getConnection());
            return bd.buscar(id);
        } catch (DAOException e) {
            throw new FacadeException("Erro ao buscar todos as refeicoes");
        }
    }
    
}
