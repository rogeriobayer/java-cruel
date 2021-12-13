/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.AtendenteBean;
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
public class AtendenteDAO {

    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone FROM cadastro_atendente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone FROM cadastro_atendente;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_atendente(login, senha, CPF, nome, email, data, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_atendente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_atendente SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ? WHERE id = ?;";

    private Connection con = null;

    public AtendenteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }

    public AtendenteBean buscar(AtendenteBean Atendente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Atendente.getId());

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Atendente.setId(rs.getInt("id"));
                Atendente.setLogin(rs.getString("login"));
//                System.out.print(rs.getString("senha"));
//                Atendente.setSenha(rs.getString(DigestUtils.sha256Hex(rs.getString("senha"))));
                Atendente.setCpf(rs.getString("CPF"));
                Atendente.setNome(rs.getString("nome"));
                Atendente.setEmail(rs.getString("email"));
                Atendente.setDate(rs.getDate("data"));
                Atendente.setEndereco(rs.getString("endereco"));
                Atendente.setTelefone(rs.getString("telefone"));
                return Atendente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Atendente.getId(), e);
        }
    }

    public List<AtendenteBean> buscarTodos() throws Exception {
        List<AtendenteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AtendenteBean user = new AtendenteBean();
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
            throw new Exception("Erro buscando todas os Atendentes: " + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(AtendenteBean Atendente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Atendente.getSenha());

            st.setString(1, Atendente.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Atendente.getCpf());
            st.setString(4, Atendente.getNome());
            st.setString(5, Atendente.getEmail());
            st.setDate(6, Atendente.getDate());
            st.setString(7, Atendente.getEndereco());
            st.setString(8, Atendente.getTelefone());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(AtendenteBean Atendente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Atendente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(AtendenteBean Atendente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Atendente.getSenha());

            st.setString(1, Atendente.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Atendente.getCpf());
            st.setString(4, Atendente.getNome());
            st.setString(5, Atendente.getEmail());
            st.setDate(6, Atendente.getDate());
            st.setString(7, Atendente.getEndereco());
            st.setString(8, Atendente.getTelefone());
            st.setInt(9, Atendente.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
}
