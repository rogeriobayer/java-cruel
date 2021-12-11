/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;
import com.ufpr.tads.web2.beans.ExternoBean;
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
public class ExternoDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone, observacao FROM cadastro_externo WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone FROM cadastro_externo;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_externo(login, senha, CPF, nome, email, data, endereco, telefone, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_externo WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_externo SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ?, observacao = ? WHERE id = ?;";
    
    private Connection con = null;

    public ExternoDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public ExternoBean buscar(ExternoBean Externo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, Externo.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Externo.setId(rs.getInt("id"));
                Externo.setLogin(rs.getString("login"));
                Externo.setSenha(rs.getString(DigestUtils.sha256Hex(Externo.getSenha())));
                Externo.setCpf(rs.getString("CPF"));
                Externo.setNome(rs.getString("nome"));
                Externo.setEmail(rs.getString("email"));
                Externo.setDate(rs.getDate("data"));
                Externo.setEndereco(rs.getString("endereco"));
                Externo.setTelefone(rs.getString("telefone"));
                Externo.setObservacao(rs.getString("observacao"));
                return Externo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + Externo.getId(), e);
        }
    }
    
    public List<ExternoBean> buscarTodos() throws Exception{
        List<ExternoBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ExternoBean user = new ExternoBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setObservacao(rs.getString("observacao"));

                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os Externos: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(ExternoBean Externo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(Externo.getSenha());

            st.setString(1, Externo.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Externo.getCpf());
            st.setString(4, Externo.getNome());
            st.setString(5, Externo.getEmail());
            st.setDate(6, Externo.getDate());
            st.setString(7, Externo.getEndereco());
            st.setString(8, Externo.getTelefone());
            st.setString(9, Externo.getObservacao());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(ExternoBean Externo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Externo.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(ExternoBean Externo) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(Externo.getSenha());

            st.setString(1, Externo.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, Externo.getCpf());
            st.setString(4, Externo.getNome());
            st.setString(5, Externo.getEmail());
            st.setDate(6, Externo.getDate());
            st.setString(7, Externo.getEndereco());
            st.setString(8, Externo.getTelefone());
            st.setString(9, Externo.getObservacao());
            st.setInt(10, Externo.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
}
