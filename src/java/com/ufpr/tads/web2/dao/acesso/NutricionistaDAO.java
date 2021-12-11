/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.NutricionistaBean;
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
public class NutricionistaDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone, crn FROM cadastro_nutri WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone, crn FROM cadastro_nutri;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_nutri(login, senha, CPF, nome, email, data, endereco, telefone, crn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_nutri WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_nutri SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ?, crn = ? WHERE id = ?;";
    
    private Connection con = null;
    
    public NutricionistaDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public NutricionistaBean buscar(NutricionistaBean Nutricionista) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Nutricionista.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Nutricionista.setId(rs.getInt("id"));
                Nutricionista.setLogin(rs.getString("login"));
                Nutricionista.setSenha(rs.getString(DigestUtils.sha256Hex(Nutricionista.getSenha())));
                Nutricionista.setCpf(rs.getString("CPF"));
                Nutricionista.setNome(rs.getString("nome"));
                Nutricionista.setEmail(rs.getString("email"));
                Nutricionista.setDate(rs.getDate("data"));
                Nutricionista.setEndereco(rs.getString("endereco"));
                Nutricionista.setTelefone(rs.getString("telefone"));
                Nutricionista.setCrn(rs.getString("crn"));
                return Nutricionista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Nutricionista.getId(), e);
        }
    }
    
    public List<NutricionistaBean> buscarTodos() throws Exception{
        List<NutricionistaBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                NutricionistaBean user = new NutricionistaBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setCrn(rs.getString("crn"));

                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os Nutricionistas: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(NutricionistaBean Nutricionista) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Nutricionista.getSenha());

            st.setString(1, Nutricionista.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Nutricionista.getCpf());
            st.setString(4, Nutricionista.getNome());
            st.setString(5, Nutricionista.getEmail());
            st.setDate(6, Nutricionista.getDate());
            st.setString(7, Nutricionista.getEndereco());
            st.setString(8, Nutricionista.getTelefone());
            st.setString(9, Nutricionista.getCrn());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(NutricionistaBean Nutricionista) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Nutricionista.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(NutricionistaBean Nutricionista) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Nutricionista.getSenha());

            st.setString(1, Nutricionista.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Nutricionista.getCpf());
            st.setString(4, Nutricionista.getNome());
            st.setString(5, Nutricionista.getEmail());
            st.setDate(6, Nutricionista.getDate());
            st.setString(7, Nutricionista.getEndereco());
            st.setString(8, Nutricionista.getTelefone());
            st.setString(9, Nutricionista.getCrn());
            st.setInt(10, Nutricionista.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
    
}
