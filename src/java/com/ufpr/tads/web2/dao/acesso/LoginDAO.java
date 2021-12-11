/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.LoginBean;
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
public class LoginDAO {

    private static final String QUERY_BUSCAR = "SELECT id, cargo FROM login WHERE login=? AND senha=?;";
    private static final String QUERY_BUSCAR_LOGIN = "SELECT id FROM login WHERE login=?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, login FROM login;";
    private static final String QUERY_INSERIR = "INSERT INTO login(login, senha) VALUES (?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM login WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE login SET login = ?, senha = ? WHERE id = ?;";
    private static final String QUERY_EDITAR_SENHA = "UPDATE login SET senha = ? WHERE id = ?;";

    private Connection con = null;

    public LoginDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar LoginDAO.");
        }
        this.con = con;
    }

    public LoginBean buscarLogin(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_LOGIN)) {
            st.setString(1, login.getLogin());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                login.setId(rs.getInt("id"));
                return login;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + login.getLogin(), e);
        }
    }

    public LoginBean buscar(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            String sha256hex = DigestUtils.sha256Hex(login.getSenha());
            System.out.print(sha256hex);

            st.setString(1, login.getLogin());
            st.setString(2, sha256hex);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                login.setId(rs.getInt("id"));
                login.setCargo(rs.getString("cargo"));
                return login;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + login.getLogin(), e);
        }
    }

    public List<LoginBean> buscarTodos() throws Exception {
        List<LoginBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                LoginBean user = new LoginBean();
                user.setLogin(rs.getString("login"));
                user.setId(rs.getInt("id"));
                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os logins: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(login.getSenha());

            st.setString(1, login.getLogin());
            st.setString(2, sha256hex);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, login.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar cliente: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(login.getSenha());

            st.setString(1, login.getLogin());
            st.setString(2, sha256hex);
            st.setInt(3, login.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }

    public void editarSenha(LoginBean login) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR_SENHA)) {
            String sha256hex = DigestUtils.sha256Hex(login.getSenha());

            st.setString(1, sha256hex);
            st.setInt(2, login.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar senha: "
                    + QUERY_EDITAR_SENHA, e);
        }
    }
}
