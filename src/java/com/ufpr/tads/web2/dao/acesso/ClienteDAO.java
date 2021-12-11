/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.ClienteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anado
 */
public class ClienteDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, data_hora, CPF, valor, categoria FROM registrar_cliente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, data_hora, CPF, valor, categoria FROM registrar_cliente;";
    private static final String QUERY_INSERIR = "INSERT INTO registrar_cliente(data_hora, CPF, valor, categoria) VALUES (?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM registrar_cliente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE categoria SET data_hora = ?, CPF = ?, valor = ?, categoria = ? WHERE id = ?;";
    
    private Connection con = null;
    
    public ClienteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar ClienteDAO.");
        }
        this.con = con;
    }
    
    public ClienteBean buscar(ClienteBean Cliente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            
            st.setInt(1, Cliente.getId());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cliente.setId(rs.getInt("id"));
                Cliente.setData_hora(rs.getTimestamp("data_hora"));
                Cliente.setCpf(rs.getString("CPF"));
                Cliente.setValor(rs.getDouble("valor"));
                Cliente.setCategoria(rs.getString("categoria"));
                
                return Cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando Cliente: " + Cliente.getId(), e);
        }
    }

    public List<ClienteBean> buscarTodos() throws Exception {
        List<ClienteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClienteBean user = new ClienteBean();
                user.setId(rs.getInt("id"));
                user.setData_hora(rs.getTimestamp("data_hora"));
                user.setCpf(rs.getString("CPF"));
                user.setValor(rs.getDouble("valor"));
                user.setCategoria(rs.getString("categoria"));
                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todos os Clientes: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(ClienteBean Cliente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {

            st.setTimestamp(1, Cliente.getData_hora());
            st.setString(2, Cliente.getCpf());
            st.setDouble(3, Cliente.getValor());
            st.setString(4, Cliente.getCategoria());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar Cliente: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(ClienteBean Cliente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, Cliente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar cliente: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(ClienteBean Cliente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {

            st.setTimestamp(1, Cliente.getData_hora());
            st.setString(2, Cliente.getCpf());
            st.setDouble(3, Cliente.getValor());
            st.setString(4, Cliente.getCategoria());
            st.setInt(5, Cliente.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar Cliente: "
                    + QUERY_EDITAR, e);
        }
    }
}
