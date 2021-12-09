package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.CategoriaBean;
import com.ufpr.tads.web2.dao.acesso.CategoriaDAO;
import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.util.List;

/**
 *
 * @author Bayer
 */
public class CategoriaFacade {

    public CategoriaFacade() {
    }

    public static CategoriaBean categoriaPorNome(CategoriaBean categoria) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        return categoriadao.categoriaPorNome(categoria);
    }

    public static CategoriaBean categoria(CategoriaBean categoria) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        return categoriadao.categoria(categoria);
    }

    public static List<CategoriaBean> buscarTodos() throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        return categoriadao.buscarTodos();
    }

    public static void inserir(CategoriaBean categoria) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        categoriadao.inserir(categoria);
    }

    public static void remover(CategoriaBean categoria) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        categoriadao.inserir(categoria);
    }

    public static void editar(CategoriaBean categoria) throws ClassNotFoundException, Exception {
        ConnectionFactory conn = new ConnectionFactory();
        CategoriaDAO categoriadao = new CategoriaDAO(conn.getConnection());
        categoriadao.inserir(categoria);
    }

}
