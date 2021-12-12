/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anado
 */
public class RegistrarClienteDAO {

    private static final String QUERY_BUSCAR_TIPO_CLIENTE = 
        "SELECT cli.cpf, cli.cargo FROM ( " +
"	SELECT alu.cpf, 'Aluno' AS cargo FROM cadastro_aluno alu " +
"	UNION " +
"	SELECT ser.cpf, 'Servidor' AS cargo FROM cadastro_servidor ser " +
"	UNION " +
"	SELECT ext.cpf, 'Externo' AS cargo FROM cadastro_externo ext " +
"	UNION " +
"	SELECT pro.cpf, 'Professor' AS cargo FROM cadastro_professor pro " +
") AS cli WHERE cli.cpf = ?";
    
    private static final String QUERY_INSERIR_ATENDIMENTO = 
            "INSERT INTO registrar_cliente (data_hora, cpf, valor, categoria, removido) VALUES (?, ?, ?, ?, false);";

    private static final String QUERY_BUSCAR_REGISTROS_POR_PERÍODO = 
            "select rc.id, rc.data_hora, rc.cpf, rc.valor, rc.justificativa from registrar_cliente rc " +
            "where rc.data_hora between ? and ? " +
            "and removido = false " +
            "order by rc.data_hora desc, rc.id ";
    
    private static final String QUERY_BUSCAR_REGISTRO_POR_ID = 
            "select rc.id, rc.data_hora, rc.cpf, rc.valor, rc.justificativa from registrar_cliente rc " +
            "where rc.id = ?";
    
    private static final String QUERY_APAGA_REGISTRO_POR_ID =
            "update registrar_cliente set removido = true, justificativa = ? " +
            "where id  = ?";
    
     private static final String QUERY_ATUALIZA_REGISTRO_POR_ID =
    "update registrar_cliente set cpf = ?, data_hora = ?, valor = ?, categoria = ?, justificativa = ? "+  
    "where id  = ?";
     
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


    public List<RegistrarClienteBean> buscarRegistrosDia(Date dataInicial, Date dataFinal) {
        List<RegistrarClienteBean> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_REGISTROS_POR_PERÍODO)) {
            st.setTimestamp(1,new java.sql.Timestamp(dataInicial.getTime()));
            st.setTimestamp(2,new java.sql.Timestamp(dataFinal.getTime()));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer idRegistro = rs.getInt("id");
                Timestamp dataHoraRegistroBD = rs.getTimestamp("data_hora");
                String cpfRegistro = rs.getString("cpf");
                Double valorRegistro = rs.getDouble("valor");
                String justificativaRegistro = rs.getString("justificativa");
                
                Date dataHoraRegistro = new Date(dataHoraRegistroBD.getTime());
                
                RegistrarClienteBean registroAtendimento = new RegistrarClienteBean(idRegistro, cpfRegistro, dataHoraRegistro, valorRegistro);
                registroAtendimento.setJustificativa(justificativaRegistro);
                                
                lista.add(registroAtendimento);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro buscando todas os Registros: " + QUERY_BUSCAR_REGISTROS_POR_PERÍODO, e);

        }
    }

    public RegistrarClienteBean buscarRegistro(Integer id) {
        RegistrarClienteBean registroAtendimento = null;
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_REGISTRO_POR_ID)) {
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Integer idRegistro = rs.getInt("id");
                Timestamp dataHoraRegistroBD = rs.getTimestamp("data_hora");
                String cpfRegistro = rs.getString("cpf");
                Double valorRegistro = rs.getDouble("valor");
                String justificativaRegistro = rs.getString("justificativa");
                
                Date dataHoraRegistro = new Date(dataHoraRegistroBD.getTime());
                
                registroAtendimento = new RegistrarClienteBean(idRegistro, cpfRegistro, dataHoraRegistro, valorRegistro);
                registroAtendimento.setJustificativa(justificativaRegistro);
            }
            return registroAtendimento;
        } catch (SQLException e) {
            throw new RuntimeException("Erro buscando um Registro: " + QUERY_BUSCAR_REGISTRO_POR_ID, e);
        }
    }

    public void apagaRegistro(Integer id, String justificativa) {
        try (PreparedStatement st = con.prepareStatement(QUERY_APAGA_REGISTRO_POR_ID)) {
            st.setString(1,justificativa);
            st.setInt(2,id);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro buscando apagando Registro: " + QUERY_APAGA_REGISTRO_POR_ID, e);
        }
    }

    public void atualizaRegistro(RegistrarClienteBean inputCliente) {
        String categoria = buscarTipoCliente(inputCliente);
        
        try (PreparedStatement st = con.prepareStatement(QUERY_ATUALIZA_REGISTRO_POR_ID)) {
            st.setString(1,inputCliente.getCpf());
            st.setTimestamp(2,new Timestamp(inputCliente.getDataHora().getTime()));
            st.setDouble(3,inputCliente.getValor());
            st.setString(4,categoria);
            st.setString(5,inputCliente.getJustificativa());
            st.setInt(6, inputCliente.getId());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro atualizando Registro: " + QUERY_ATUALIZA_REGISTRO_POR_ID, e);
        }       
    }
}

