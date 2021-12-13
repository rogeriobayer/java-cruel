/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.Refeicao;
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
public class RefeicaoDAO {
    private Connection con = null;
    
    private static final String QUERY_BUSCAR_POR_CONTRATO = "SELECT id, turno, id_cardapio from refeicao where id_cardapio=?;";

    public RefeicaoDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar cardapioDAO.");
        }
        this.con = con;
    }

    public RefeicaoDAO() {
    }
    
    public List<Refeicao> buscar(Integer idRefeicao) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_CONTRATO)) {
            st.setInt(1, idRefeicao);
            ResultSet rs = st.executeQuery();
            List<Refeicao> lista = new ArrayList<>();
            if (rs.next()) {
                Refeicao t = new Refeicao();
                t.setId(rs.getInt("id"));
                t.setTurno(rs.getString("turno"));
                lista.add(t);
            } 
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando tipo: " + idRefeicao, e);
        }
    }
}
