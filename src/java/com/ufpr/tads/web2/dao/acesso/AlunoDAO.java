/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.AlunoBean;
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
public class AlunoDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, login, senha, CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr FROM cadastro_aluno WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr FROM cadastro_aluno;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_aluno(login, senha, CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_aluno WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cadastro_aluno SET login = ?, senha = ?, CPF = ?, nome = ?, email = ?, data = ?, endereco = ?, telefone = ?, curso = ?, ano_ingresso = ?, grr = ? WHERE id = ?;";
    
    private Connection con = null;

    public AlunoDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
    
    public AlunoBean buscar(AlunoBean aluno) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {

            st.setInt(1, aluno.getId());

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setLogin(rs.getString("login"));
                aluno.setSenha(rs.getString(DigestUtils.sha256Hex(aluno.getSenha())));
                aluno.setCpf(rs.getString("CPF"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setDate(rs.getDate("data"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setAno(rs.getInt("ano_ingresso"));
                aluno.setGrr(rs.getString("grr"));
                return aluno;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando login: " + aluno.getId(), e);
        }
    }
    
    public List<AlunoBean> buscarTodos() throws Exception{
        List<AlunoBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AlunoBean user = new AlunoBean();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("CPF"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("data"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setCurso(rs.getString("curso"));
                user.setAno(rs.getInt("ano_ingresso"));
                user.setGrr(rs.getString("grr"));
                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todas os alunos: " + QUERY_BUSCAR_TODOS, e);

        }
    }
    
    public void inserir(AlunoBean aluno) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            String sha256hex = DigestUtils.sha256Hex(aluno.getSenha());

            st.setString(1, aluno.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, aluno.getCpf());
            st.setString(4, aluno.getNome());
            st.setString(5, aluno.getEmail());
            st.setDate(6, aluno.getDate());
            st.setString(7, aluno.getEndereco());
            st.setString(8, aluno.getTelefone());
            st.setString(9, aluno.getCurso());
            st.setInt(10, aluno.getAno());
            st.setString(11, aluno.getGrr());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_INSERIR, e);
        }
    }
    
    public void remover(AlunoBean aluno) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, aluno.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("Erro ao criar login: "
                    + QUERY_REMOVER, e);
        }
    }
    
    public void editar(AlunoBean aluno) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            String sha256hex = DigestUtils.sha256Hex(aluno.getSenha());

            st.setString(1, aluno.getLogin());
            st.setString(2, sha256hex);
            st.setString(3, aluno.getCpf());
            st.setString(4, aluno.getNome());
            st.setString(5, aluno.getEmail());
            st.setDate(6, aluno.getDate());
            st.setString(7, aluno.getEndereco());
            st.setString(8, aluno.getTelefone());
            st.setString(9, aluno.getCurso());
            st.setInt(10, aluno.getAno());
            st.setString(11, aluno.getGrr());
            st.setInt(12, aluno.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar login: "
                    + QUERY_EDITAR, e);
        }
    }
}
