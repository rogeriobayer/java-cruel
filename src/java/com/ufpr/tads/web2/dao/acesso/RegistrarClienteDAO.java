/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.ClienteBean;
import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author anado
 */
public class RegistrarClienteDAO {

    private static final String QUERY_BUSCAR_TIPO_CLIENTE = "SELECT cli.cpf, cli.cargo FROM ( " +
"	SELECT alu.cpf, 'Aluno' AS cargo FROM cadastro_aluno alu " +
"	UNION " +
"	SELECT ser.cpf, 'Servidor' AS cargo FROM cadastro_servidor ser " +
"	UNION " +
"	SELECT ext.cpf, 'Externo' AS cargo FROM cadastro_externo ext " +
"	UNION " +
"	SELECT pro.cpf, 'Professor' AS cargo FROM cadastro_professor pro " +
") AS cli WHERE cli.cpf = ?";
    
    private static final String QUERY_INSERIR_ATENDIMENTO = "INSERT INTO registrar_cliente (data_hora, cpf, valor, categoria) VALUES (?, ?, ?, ?);";

    
    private Connection con = null;
    
    public RegistrarClienteDAO(Connection con) {
        if (con == null) {
            throw new RuntimeException("Conexão nula ao criar RegistrarClienteDAO.");
        }
        this.con = con;
    }
    
    public void registrarAtendimento(RegistrarClienteBean inputCliente) {
        String tipoCliente = buscarTipoCliente(inputCliente);
        
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ATENDIMENTO)) {   
            st.setTimestamp(1, new java.sql.Timestamp(inputCliente.getDataHora().getTime()));
            st.setString(2, inputCliente.getCpf());
            st.setDouble(3, inputCliente.getValor());
            st.setString(4, tipoCliente);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar atendimento: "
                    + QUERY_INSERIR_ATENDIMENTO, e);
        }
    }
    
    private String buscarTipoCliente(RegistrarClienteBean registrarCliente) {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TIPO_CLIENTE)) {
            
            st.setString(1, registrarCliente.getCpf());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("cargo");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro buscando Tipo do Cliente: " + registrarCliente.getCpf(), e);
        }
    }

//    public void inserir(ClienteBean Cliente) throws Exception {
//        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
//
//            st.setTimestamp(1, Cliente.getData_hora());
//            st.setString(2, Cliente.getCpf());
//            st.setDouble(3, Cliente.getValor());
//            st.setString(4, Cliente.getCategoria());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            throw new Exception("Erro ao criar Cliente: "
//                    + QUERY_INSERIR, e);
//        }
//    }
//
//    public void remover(ClienteBean Cliente) throws Exception {
//        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
//            st.setInt(1, Cliente.getId());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            throw new Exception("Erro ao deletar cliente: "
//                    + QUERY_REMOVER, e);
//        }
//    }
//
//    public void editar(ClienteBean Cliente) throws Exception {
//        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
//
//            st.setTimestamp(1, Cliente.getData_hora());
//            st.setString(2, Cliente.getCpf());
//            st.setDouble(3, Cliente.getValor());
//            st.setString(4, Cliente.getCategoria());
//            st.setInt(5, Cliente.getId());
//
//            st.executeUpdate();
//        } catch (SQLException e) {
//            throw new Exception("Erro ao editar Cliente: "
//                    + QUERY_EDITAR, e);
//        }
//    }

}
