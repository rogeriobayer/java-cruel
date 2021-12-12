/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.database;

import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author anado
 */
public class AtualizarTabelaRegistrarCliente {
    private static Connection con = null;

    public static void main(String[] args) {
        Statement query = null;
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();
            
            query.executeUpdate("DROP TABLE IF EXISTS registrar_cliente;");
            query.executeUpdate("CREATE TABLE public.registrar_cliente (" +
                                "	id serial4 NOT NULL," +
                                "	data_hora timestamp NULL," +
                                "	cpf varchar(11) NULL," +
                                "	valor float8 NULL," +
                                "	categoria varchar(50) NULL," +
                                "	removido bool NOT NULL," +
                                "	justificativa varchar(255) NULL," +
                                "	CONSTRAINT registrar_cliente_pkey PRIMARY KEY (id)" +
                                ");");
            query.executeUpdate("ALTER TABLE public.registrar_cliente ADD CONSTRAINT registrar_cliente_categoria_fkey FOREIGN KEY (categoria) REFERENCES public.categoria(categoria);");

            System.out.println("Atendente Cadastrado com sucesso criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Atendente.");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (query != null) {
                try {
                    query.close();
                    query = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
