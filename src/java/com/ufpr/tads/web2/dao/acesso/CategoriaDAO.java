package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.CategoriaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anado
 */
public class CategoriaDAO {

    private static final String QUERY_BUSCAR = "SELECT categoria FROM categoria WHERE id = ?;";
    private static final String QUERY_BUSCAR_POR_NOME = "SELECT id FROM categoria WHERE categoria = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, categoria FROM categoria;";
    private static final String QUERY_INSERIR = "INSERT INTO categoria(categoria) VALUES (?);";
    private static final String QUERY_REMOVER = "DELETE FROM categoria WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE categoria SET categoria = ? WHERE id = ?;";

    private Connection con = null;

    public CategoriaDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }

    public CategoriaBean categoriaPorNome(CategoriaBean categoria) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_NOME)) {
            st.setString(1, categoria.getCategoria());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                return categoria;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando categoria: " + categoria.getCategoria(), e);
        }
    }

    public CategoriaBean categoria(CategoriaBean categoria) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, categoria.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                categoria.setCategoria(rs.getString("categoria"));
                return categoria;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando categoria: " + categoria.getId(), e);
        }
    }

    public List<CategoriaBean> buscarTodos() throws Exception {
        List<CategoriaBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriaBean categoria = new CategoriaBean();
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os perfis: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(CategoriaBean categoria) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, categoria.getCategoria());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar categoria: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(CategoriaBean categoria) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, categoria.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar categoria: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(CategoriaBean categoria) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {

            st.setString(1, categoria.getCategoria());
            st.setInt(2, categoria.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar categoria: "
                    + QUERY_EDITAR, e);
        }
    }
}
