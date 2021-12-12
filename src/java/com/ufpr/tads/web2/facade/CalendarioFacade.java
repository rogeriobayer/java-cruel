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

/**
 *
 * @author julia
 */
public class CalendarioFacade {
    
    public CalendarioFacade(){
    }
    
    public static List<Integer> buscarMeses() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CardapioDAO IngredienteDao = new CardapioDAO(conn.getConnection());
        return IngredienteDao.buscarMeses();
    }
}
