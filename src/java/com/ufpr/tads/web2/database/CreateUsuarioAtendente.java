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
public class CreateUsuarioAtendente {
    private static Connection con = null;

    public static void main(String[] args) {
        PreparedStatement query = null;
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            
            final String sql = "INSERT INTO login(login, senha, cargo) VALUES (?, ?, ?)";
            
            query = con.prepareStatement(sql);
            query.setString(1, "julia");
            query.setString(2, DigestUtils.sha256Hex("julia123"));
            query.setString(3, "ate");

            query.executeUpdate();

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
