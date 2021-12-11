/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.ProfessorBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author anado
 */
public class ProfessorDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone, depto, area_estudo FROM cadastro_professor WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone, depto, area_estudo FROM cadastro_professor;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_professor(login, senha, CPF, nome, email, data, endereco, telefone, depto, area_estudo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_professor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_professor SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ?, depto = ?, area_estudo = ? WHERE id = ?;";
    
    private Connection con = null;
    
    public ProfessorDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public ProfessorBean buscar(ProfessorBean Professor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Professor.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Professor.setId(rs.getInt("id"));
                Professor.setLogin(rs.getString("login"));
                Professor.setSenha(rs.getString(DigestUtils.sha256Hex(Professor.getSenha())));
                Professor.setCpf(rs.getString("CPF"));
                Professor.setNome(rs.getString("nome"));
                Professor.setEmail(rs.getString("email"));
                Professor.setDate(rs.getDate("data"));
                Professor.setEndereco(rs.getString("endereco"));
                Professor.setTelefone(rs.getString("telefone"));
                Professor.setDepto(rs.getString("depto"));
                Professor.setArea_estudo(rs.getString("area_estudo"));
                return Professor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Professor.getId(), e);
        }
    }
    
    public List<ProfessorBean> buscarTodos() throws Exception{
        List<ProfessorBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProfessorBean user = new ProfessorBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setDepto(rs.getString("depto"));
                user.setArea_estudo(rs.getString("area_estudo"));

                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os Professors: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(ProfessorBean Professor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Professor.getSenha());

            st.setString(1, Professor.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Professor.getCpf());
            st.setString(4, Professor.getNome());
            st.setString(5, Professor.getEmail());
            st.setDate(6, Professor.getDate());
            st.setString(7, Professor.getEndereco());
            st.setString(8, Professor.getTelefone());
            st.setString(9, Professor.getDepto());
            st.setString(10, Professor.getArea_estudo());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(ProfessorBean Professor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Professor.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(ProfessorBean Professor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Professor.getSenha());

            st.setString(1, Professor.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Professor.getCpf());
            st.setString(4, Professor.getNome());
            st.setString(5, Professor.getEmail());
            st.setDate(6, Professor.getDate());
            st.setString(7, Professor.getEndereco());
            st.setString(8, Professor.getTelefone());
            st.setString(9, Professor.getDepto());
            st.setString(10, Professor.getArea_estudo());
            st.setInt(11, Professor.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
    
}
