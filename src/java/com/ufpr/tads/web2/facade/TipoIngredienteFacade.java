/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.TipoIngrediente;
import com.ufpr.tads.web2.dao.acesso.TipoIngredienteDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import exceptions.DAOException;
import exceptions.FacadeException;
import java.util.List;

/**
 *
 * @author anado
 */
public class TipoIngredienteFacade {

    public TipoIngredienteFacade() {
    }

    public static TipoIngrediente buscar(TipoIngrediente tipo) throws ClassNotFoundException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            TipoIngredienteDAO bd = new TipoIngredienteDAO(factory.getConnection());
            return bd.buscar(tipo);
        } catch (DAOException e) {
            throw new FacadeException("Erro ao buscar tipo");
        }
    }

    public static List<TipoIngrediente> buscarTodos() throws ClassNotFoundException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            TipoIngredienteDAO bd = new TipoIngredienteDAO(factory.getConnection());
            return bd.buscarTodos();
        } catch (DAOException e) {
            throw new FacadeException("Erro ao buscar todos os tipo");
        }
    }

    public static void inserir(TipoIngrediente t) throws FacadeException, Exception {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            TipoIngredienteDAO bd = new TipoIngredienteDAO(factory.getConnection());
            bd.inserir(t);
        } catch (DAOException e) {
            throw new FacadeException("Erro ao inserir tipo");
        }
    }

    public static void remover(int id) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        TipoIngredienteDao.remover(id);
    }

    public static void editar(TipoIngrediente tipo) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        TipoIngredienteDAO TipoIngredienteDao = new TipoIngredienteDAO(conn.getConnection());
        TipoIngredienteDao.editar(tipo);
    }
}
