/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.RefeicaoIngrediente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author julia
 */
public class RefeicaoIngredienteDAO {
    private Connection con = null;
    
    private static final String QUERY_BUSCAR_POR_REFEICAO = "SELECT refeicao_ingrediente.id, id_refeicao, id_ingrediente, quantidade, nome from refeicao_ingrediente, ingrediente\n" +
"where ingrediente.id = id_ingrediente and id_refeicao = ?;";

    public RefeicaoIngredienteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar cardapioDAO.");
        }
        this.con = con;
    }

    public RefeicaoIngredienteDAO() {
    }
    
    public List<RefeicaoIngrediente> buscar(Integer idContrato) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_REFEICAO)) {
            st.setInt(1, idContrato);
            ResultSet rs = st.executeQuery();
            List<RefeicaoIngrediente> lista = new ArrayList<>();
            while (rs.next()) {
                RefeicaoIngrediente t = new RefeicaoIngrediente();
                t.setId(rs.getInt("id"));
                t.setIdRefeicao(rs.getInt("id_refeicao"));
                t.setIdIngrediente(rs.getInt("id_ingrediente"));
                t.setQuantidade(rs.getInt("quantidade"));
                t.setNome(rs.getString("nome"));
                lista.add(t);
            } 
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando tipo: " + idContrato, e);
        }
    }
    
}
