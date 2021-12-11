/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.IngredienteBean;
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
public class IngredienteDAO {
    
    private static final String QUERY_BUSCAR = "SELECT nome, tipo, descricao FROM ingrediente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome, tipo, descricao FROM ingrediente;";
    private static final String QUERY_INSERIR = "INSERT INTO ingrediente(nome, tipo, descricao) VALUES (?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM ingrediente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE ingrediente SET nome = ?, tipo = ?, descricao = ? WHERE id = ?;";

    private Connection con = null;

    public IngredienteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
       public IngredienteBean buscar(IngredienteBean ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, ingrediente.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setTipo(rs.getInt("tipo"));
                ingrediente.setDescricao(rs.getString("descricao"));
                return ingrediente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando ingrediente: " + ingrediente.getId(), e);
        }
    }

    public List<IngredienteBean> buscarTodos() throws Exception {
        List<IngredienteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                IngredienteBean ingrediente = new IngredienteBean();
                ingrediente.setId(rs.getInt("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setTipo(rs.getInt("tipo"));
                ingrediente.setDescricao(rs.getString("descricao"));
                lista.add(ingrediente);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os perfis: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(IngredienteBean ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, ingrediente.getNome());
            st.setInt(2, ingrediente.getTipo());
            st.setString(3, ingrediente.getDescricao());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar categoria: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(IngredienteBean ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, ingrediente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar categoria: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(IngredienteBean ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {

            st.setString(1, ingrediente.getNome());
            st.setInt(2, ingrediente.getTipo());
            st.setString(3, ingrediente.getDescricao());
            st.setInt(4, ingrediente.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar categoria: "
                    + QUERY_EDITAR, e);
        }
    }
}
