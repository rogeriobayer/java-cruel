/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.util.List;
import com.ufpr.tads.web2.beans.Cardapio;
import com.ufpr.tads.web2.dao.acesso.CardapioDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import exceptions.DAOException;
import exceptions.FacadeException;

/**
 *
 * @author julia
 */
public class CardapioFacade {

    public static List<Cardapio> buscarTodos() throws FacadeException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CardapioDAO bd = new CardapioDAO(factory.getConnection());
            return bd.buscarTodos();
        } catch (DAOException e) {
            throw new FacadeException("Erro ao buscar todos os tipo");
        }
    }
    
    public static Cardapio buscar(int id) throws FacadeException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CardapioDAO bd = new CardapioDAO(factory.getConnection());
            return bd.buscar(id);
        } catch (DAOException e) {
            throw new FacadeException("Erro ao buscar todos os tipo");
        }
    }
    
    public CardapioFacade(){
    }
    
    
    public static List<Cardapio> buscarMes(Integer mes, Integer ano) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CardapioDAO CardapioDao = new CardapioDAO(conn.getConnection());
        return CardapioDao.buscarMes(mes,ano);
    }
    
    public static int getQuantidadeDiasByMes(Integer mes) throws ClassNotFoundException, Exception {
        CardapioDAO CardapioDao = new CardapioDAO();
        return CardapioDao.getQuantidadeDiasByMes(mes);
    }
}
