/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.TipoIngredienteBean;
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
public class TipoIngredienteDAO {
    
    private static final String QUERY_BUSCAR = "SELECT nome FROM tipo_ingrediente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome FROM tipo_ingrediente;";
    private static final String QUERY_INSERIR = "INSERT INTO tipo_ingrediente(nome) VALUES (?);";
    private static final String QUERY_REMOVER = "DELETE FROM tipo_ingrediente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE tipo_ingrediente SET nome = ? WHERE id = ?;";

    private Connection con = null;

    public TipoIngredienteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public TipoIngredienteBean buscar(TipoIngredienteBean tipo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, tipo.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                tipo.setNome(rs.getString("nome"));
                return tipo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando tipo: " + tipo.getId(), e);
        }
    }

    public List<TipoIngredienteBean> buscarTodos() throws Exception {
        List<TipoIngredienteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TipoIngredienteBean tipo = new TipoIngredienteBean();
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                lista.add(tipo);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os perfis: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(TipoIngredienteBean tipo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, tipo.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar categoria: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(TipoIngredienteBean tipo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, tipo.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar categoria: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(TipoIngredienteBean tipo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {

            st.setString(1, tipo.getNome());
            st.setInt(2, tipo.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar categoria: "
                    + QUERY_EDITAR, e);
        }
    }
}
