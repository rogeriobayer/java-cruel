/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.GerenteBean;
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
public class GerenteDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone FROM cadastro_gerente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone FROM cadastro_gerente;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_gerente(login, senha, CPF, nome, email, data, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_gerente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_gerente SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ? WHERE id = ?;";
    
    private Connection con = null;

    public GerenteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public GerenteBean buscar(GerenteBean Gerente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Gerente.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Gerente.setId(rs.getInt("id"));
                Gerente.setLogin(rs.getString("login"));
                Gerente.setSenha(rs.getString(DigestUtils.sha256Hex(Gerente.getSenha())));
                Gerente.setCpf(rs.getString("CPF"));
                Gerente.setNome(rs.getString("nome"));
                Gerente.setEmail(rs.getString("email"));
                Gerente.setDate(rs.getDate("data"));
                Gerente.setEndereco(rs.getString("endereco"));
                Gerente.setTelefone(rs.getString("telefone"));
                return Gerente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Gerente.getId(), e);
        }
    }
    
    public List<GerenteBean> buscarTodos() throws Exception{
        List<GerenteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GerenteBean user = new GerenteBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));

                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os Gerentes: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(GerenteBean Gerente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Gerente.getSenha());

            st.setString(1, Gerente.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Gerente.getCpf());
            st.setString(4, Gerente.getNome());
            st.setString(5, Gerente.getEmail());
            st.setDate(6, Gerente.getDate());
            st.setString(7, Gerente.getEndereco());
            st.setString(8, Gerente.getTelefone());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(GerenteBean Gerente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Gerente.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(GerenteBean Gerente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Gerente.getSenha());

            st.setString(1, Gerente.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Gerente.getCpf());
            st.setString(4, Gerente.getNome());
            st.setString(5, Gerente.getEmail());
            st.setDate(6, Gerente.getDate());
            st.setString(7, Gerente.getEndereco());
            st.setString(8, Gerente.getTelefone());
            st.setInt(9, Gerente.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
}
