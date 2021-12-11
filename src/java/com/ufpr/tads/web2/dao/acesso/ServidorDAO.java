/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.ServidorBean;
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
public class ServidorDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone, unidade, data_ingresso FROM cadastro_servidor WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone, unidade, data_ingresso FROM cadastro_servidor;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_servidor(login, senha, CPF, nome, email, data, endereco, telefone, unidade, data_ingresso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_servidor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_servidor SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ?, unidade = ?, data_ingresso = ? WHERE id = ?;";
    
    private Connection con = null;
    
    public ServidorDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public ServidorBean buscar(ServidorBean Servidor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Servidor.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Servidor.setId(rs.getInt("id"));
                Servidor.setLogin(rs.getString("login"));
                Servidor.setSenha(rs.getString(DigestUtils.sha256Hex(Servidor.getSenha())));
                Servidor.setCpf(rs.getString("CPF"));
                Servidor.setNome(rs.getString("nome"));
                Servidor.setEmail(rs.getString("email"));
                Servidor.setDate(rs.getDate("data"));
                Servidor.setEndereco(rs.getString("endereco"));
                Servidor.setTelefone(rs.getString("telefone"));
                Servidor.setUnidade(rs.getString("unidade"));
                Servidor.setData_ingresso(rs.getDate("data_ingresso"));
                return Servidor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Servidor.getId(), e);
        }
    }
    
    public List<ServidorBean> buscarTodos() throws Exception{
        List<ServidorBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ServidorBean user = new ServidorBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setUnidade(rs.getString("unidade"));
                user.setData_ingresso(rs.getDate("data_ingresso"));

                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os Servidors: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(ServidorBean Servidor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Servidor.getSenha());

            st.setString(1, Servidor.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Servidor.getCpf());
            st.setString(4, Servidor.getNome());
            st.setString(5, Servidor.getEmail());
            st.setDate(6, Servidor.getDate());
            st.setString(7, Servidor.getEndereco());
            st.setString(8, Servidor.getTelefone());
            st.setString(9, Servidor.getUnidade());
            st.setDate(10, Servidor.getData_ingresso());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(ServidorBean Servidor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Servidor.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(ServidorBean Servidor) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Servidor.getSenha());

            st.setString(1, Servidor.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Servidor.getCpf());
            st.setString(4, Servidor.getNome());
            st.setString(5, Servidor.getEmail());
            st.setDate(6, Servidor.getDate());
            st.setString(7, Servidor.getEndereco());
            st.setString(8, Servidor.getTelefone());
            st.setString(9, Servidor.getUnidade());
            st.setDate(10, Servidor.getData_ingresso());
            st.setInt(11, Servidor.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
}
