package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.acesso.LoginDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author bayer
 */
public class LoginFacade {

    public LoginFacade() {
    }

    public static LoginBean buscarLogin(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        return loginDao.buscarLogin(login);
    }

    public static LoginBean buscar(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        return loginDao.buscar(login);
    }

    public static List<LoginBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        return loginDao.buscarTodos();
    }

    public static void inserir(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        loginDao.inserir(login);
    }

    public static void remover(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        loginDao.remover(login);
    }

    public static void editar(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        loginDao.editar(login);
    }

    public static void editarSenha(LoginBean login) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        LoginDAO loginDao = new LoginDAO(conn.getConnection());
        loginDao.editarSenha(login);
    }
}
